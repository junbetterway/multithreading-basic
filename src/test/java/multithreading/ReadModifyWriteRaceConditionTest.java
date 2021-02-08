/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package multithreading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.umd.cs.mtc.MultithreadedTestCase;
import edu.umd.cs.mtc.TestFramework;
import multithreading.race.condition.pattern.MyCounter;

/**
 * 
 * @author JunMinon
 *
 */
public class ReadModifyWriteRaceConditionTest extends MultithreadedTestCase {
	
	private MyCounter counter;

	@Override
	public void initialize() {
		counter = new MyCounter();
	}
	
	public void thread1() throws InterruptedException {
        counter.add(1);
    }
	
    public void thread2() throws InterruptedException {
        counter.add(1);
    }

	@Override
	public void finish() {
		Assertions.assertEquals(2, counter.getCount());
	}
	
    @Test
    public void testCounter() throws Throwable {
    	TestFramework.runManyTimes(new ReadModifyWriteRaceConditionTest(), 100);
    }
	
}
