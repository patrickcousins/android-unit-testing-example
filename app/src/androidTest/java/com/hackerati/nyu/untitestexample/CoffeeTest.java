/*
    Copyright 2014 Patrick Cousins

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.hackerati.nyu.untitestexample;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import static org.mockito.Mockito.*;
import static org.fest.assertions.api.Assertions.*;

/**
 * Class name must end with "Test" (not "Tests" plural)
 * We run it with Roboletric so it runs in a JVM instead of an emulator.
 * It is possible to run plain Java tests as JUnit this way also, but any Android specific code
 * requires either an emulator or JVM
 */
@RunWith(RobolectricTestRunner.class)
public class CoffeeTest {

    Pot mockPot;
    Heater mockHeater;
    CoffeeMaker coffeeMaker;


    /**
     * Runs before every test
     */
    @Before
    public void setup() {
        mockPot = mock(Pot.class);
        mockHeater = mock(Heater.class);
    }

    /**
     * Tests are found based on the annotation and/or name of the method
     *
     * Android's naming convention for tests:
     *
     * public void testRealMethodName_descriptionOfWhatIsBeingTested()
     */
    @Test
    public void testGetCoffee_isNotNull() {

        coffeeMaker = new CoffeeMaker(mockPot, mockHeater);

        when(mockPot.getSize()).thenReturn(-1);
        when(mockHeater.getTemp()).thenReturn(5000);

        assertThat(coffeeMaker.getCoffee()).isNotNull();

    }


}
