/*
 * Copyright 2010 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.service.search.dev.api;



public interface ResultCell
{
	
	/**
	* Set Result Column Value
	*
	* Type: string
	*
	* Value for the column in the results.
	*/
	public void setValue(String value);
	
	/**
	* Get Result Column Value
	*
	* Type: string
	*
	* Value for the column in the results.
	*/
	public String getValue();
	
	
	
	/**
	* Set Result Column Identifier
	*
	* Type: resultColumnKey
	*
	* Identifier for a result column.
	*/
	public void setKey(String key);
	
	/**
	* Get Result Column Identifier
	*
	* Type: resultColumnKey
	*
	* Identifier for a result column.
	*/
	public String getKey();
	
	
	
}

