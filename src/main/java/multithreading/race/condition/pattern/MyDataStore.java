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
package multithreading.race.condition.pattern;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Sample model for race condition pattern: check-then-act
 * 
 * @author JunMinon
 *
 */
public class MyDataStore {

	private Map<String, String> sharedMap = new HashMap<>();
	
    public void save(String key, String value) {
    	
        if(this.sharedMap.containsKey(key)){
            
            String prevVal = sharedMap.remove(key);  
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            System.out.println(Thread.currentThread().getName() + " - "+ timestamp +
            		": Data store has mapping for key: " +key + " w/ value: " + prevVal);
            
            if(null == prevVal) {
                System.out.println("[RACE CONDITION ALERT!!!] Value was already null. Why????");
            } 
            
        } else {
        	
            sharedMap.put(key, value);
            
        }
        
    }
    
    public  Map<String, String> get() {
    	return this.sharedMap;
    }
    
}
