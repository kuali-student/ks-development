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
	package org.kuali.student.service.dictionary.dev.api;
	
	
	import java.io.Serializable;
	import java.util.List;
	
	
	public class TypeSelectorBean
	 implements TypeSelectorInfo	, Serializable
	{
		
		private static final long serialVersionUID = 1L;
		
		private List<StateSelectorInfo> state;
		
		/**
		* Set State Selector
		*
		* Type: stateSelectorInfoList
		*
		* Information about fields for a particular value of the state field.
		*/
		@Override
		public void setState(List<StateSelectorInfo> state)
		{
			this.state = state;
		}
		
		/**
		* Get State Selector
		*
		* Type: stateSelectorInfoList
		*
		* Information about fields for a particular value of the state field.
		*/
		@Override
		public List<StateSelectorInfo> getState()
		{
			return this.state;
		}
						
		private String key;
		
		/**
		* Set Type Identifier
		*
		* Type: string
		*
		* Value for the type field on the object structure, which alters the field level 
		* validation expressed in the structure. If the structure does not possess a type 
		* field, but the structure still needs to be defined (perhaps due to the presence 
		* of dynamic attributes), the value here should read as "default".
		*/
		@Override
		public void setKey(String key)
		{
			this.key = key;
		}
		
		/**
		* Get Type Identifier
		*
		* Type: string
		*
		* Value for the type field on the object structure, which alters the field level 
		* validation expressed in the structure. If the structure does not possess a type 
		* field, but the structure still needs to be defined (perhaps due to the presence 
		* of dynamic attributes), the value here should read as "default".
		*/
		@Override
		public String getKey()
		{
			return this.key;
		}
						
	}

