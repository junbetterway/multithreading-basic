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
package multithreading.create;


/**
 * 
 * @author JunMinon
 *
 */
public class PrintNumber extends Thread {
    
    private int num;
    private int times;
    
    @Override
    public void run() {
        for(int i = 0; i < times; i++) {
            System.out.print(num);
        }
    }
    
    public PrintNumber(int num1, int times1) {
        num = num1;
        times = times1;
    }
    
}
