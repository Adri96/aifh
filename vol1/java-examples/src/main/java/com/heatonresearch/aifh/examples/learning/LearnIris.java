/*
 * Artificial Intelligence for Humans
 * Volume 1: Fundamental Algorithms
 * Java Version
 * http://www.aifh.org
 * http://www.jeffheaton.com
 *
 * Code repository:
 * https://github.com/jeffheaton/aifh

 * Copyright 2013 by Jeff Heaton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For more information on Heaton Research copyrights, licenses
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */

package com.heatonresearch.aifh.examples.learning;

import com.heatonresearch.aifh.general.data.BasicData;
import com.heatonresearch.aifh.learning.RBFNetwork;
import com.heatonresearch.aifh.learning.TrainGreedyRandom;
import com.heatonresearch.aifh.learning.score.ScoreFunction;
import com.heatonresearch.aifh.learning.score.ScoreRegressionData;
import com.heatonresearch.aifh.normalize.DataSet;

import java.io.InputStream;
import java.util.List;

/**
 * Learn the Iris data using an RBF network taught by the Greedy Random algorithm.
 */
public class LearnIris extends SimpleLearn {

    /**
     * Run the example.
     */
    public void process() {
        try {
            InputStream istream = this.getClass().getResourceAsStream("/iris.csv");

            DataSet ds = DataSet.load(istream);
            // The following ranges are setup for the Iris data set.  If you wish to normalize other files you will
            // need to modify the below function calls other files.
            ds.normalizeRange(0, 0, 1);
            ds.normalizeRange(1, 0, 1);
            ds.normalizeRange(2, 0, 1);
            ds.normalizeRange(3, 0, 1);
            ds.encodeEquilateral(4);
            istream.close();

            List<BasicData> trainingData = ds.extractSupervised(0, 4, 4, 2);

            RBFNetwork network = new RBFNetwork(4, 4, 2);
            ScoreFunction score = new ScoreRegressionData(trainingData);
            TrainGreedyRandom train = new TrainGreedyRandom(true, network, score);
            performIterations(train, 1000000, 0.01, true);
            query(network, trainingData);


        } catch (Throwable t) {
            t.printStackTrace();
        }


    }

    public static void main(String[] args) {
        LearnIris prg = new LearnIris();
        prg.process();
    }
}
