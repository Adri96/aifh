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

package com.heatonresearch.aifh.general.fns;

import com.heatonresearch.aifh.AIFH;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the inverse Multiquadric function.
 */
public class TestInverseMultiquadricFunction {
    @Test
    public void testEvaluate() {
        double[] params = {5, 0, 0, 0};
        InverseMultiquadricFunction funct = new InverseMultiquadricFunction(3, params, 0);
        double[] x = {-1, 0, 1};
        double y = funct.evaluate(x);
        assertEquals(0.11396057645963795, y, AIFH.DEFAULT_PRECISION);

    }

    @Test
    public void testToString() {
        double[] params = {5, 0, 0, 0};
        InverseMultiquadricFunction funct = new InverseMultiquadricFunction(3, params, 0);
        double[] x = {-1, 0, 1};
        funct.evaluate(x);
        assertEquals("[InverseMultiquadricFunction:width=5.00,center=,0.00,0.00]", funct.toString());
    }

    @Test
    public void testOther() {
        double[] params = {5, 0, 0, 0};
        InverseMultiquadricFunction funct = new InverseMultiquadricFunction(3, params, 0);
        assertEquals(3, funct.getDimensions());
        funct.setCenter(0, 100);
        assertEquals(100, funct.getCenter(0), AIFH.DEFAULT_PRECISION);
        funct.setWidth(5);
        assertEquals(5, funct.getWidth(), AIFH.DEFAULT_PRECISION);
    }
}
