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
import multithreading.race.condition.pattern.MyDataStore;

/**
 * 
 * @author JunMinon
 *
 */
public class CheckThenActRaceConditionTest extends MultithreadedTestCase {
	
	private MyDataStore store;

	@Override
	public void initialize() {
		store = new MyDataStore();
        store.save("Jun", "Humble");
	}
	
	public void thread1() throws InterruptedException {
        store.save("Jun", "Pogi");
    }
	
    public void thread2() throws InterruptedException {
        store.save("Jun", "Cute");
    }

	@Override
	public void finish() {
		Assertions.assertTrue(true);
	}
	
    @Test
    public void testStore() throws Throwable {
    	TestFramework.runManyTimes(new CheckThenActRaceConditionTest(), 10);
    }
	
}
