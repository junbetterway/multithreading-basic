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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import multithreading.pool.nosync.AccountNoSync;
import multithreading.pool.nosync.DepositProcessor;

/**
 * 
 * @author JunMinon
 *
 */
public class AccountNoSyncTest {

	@Test
	void test() {

		ExecutorService executor = Executors.newCachedThreadPool();
		AccountNoSync account = new AccountNoSync();
		
		for(int i = 0; i < 10; i++) {
			executor.execute(new DepositProcessor(account, 100.0));
		}
		
		executor.shutdown();
		while(!executor.isShutdown()) {}
		
		Assertions.assertEquals(1000.0, account.getBalance());
		
	}
	
}
