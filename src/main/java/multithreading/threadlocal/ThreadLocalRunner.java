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
package multithreading.threadlocal;

/**
 * 
 * @author JunMinon
 *
 */
public class ThreadLocalRunner implements Runnable {
	
    private ThreadLocal<Integer> threadLocalVar = new ThreadLocal<>();
    
	@Override
	public void run() {

		int random = (int) (Math.random() * 100);
		
		System.out.println(Thread.currentThread().getName() + " - random number is: " + random);
		
        threadLocalVar.set( 100 + random );
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println(Thread.currentThread().getName() + " - threadLocalVar: " + threadLocalVar.get());
        
    }

}
