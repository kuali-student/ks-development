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
	
	
	public class ObjectStructureBean
	 implements ObjectStructureInfo	, Serializable
	{
		
		private static final long serialVersionUID = 1L;
		
		private List<TypeSelectorInfo> type;
		
		/**
		* Set Type Selector
		*
		* Type: typeSelectorInfoList
		*
		* Information about states and fields for a particular value of the type field.
		*/
		@Override
		public void setType(List<TypeSelectorInfo> type)
		{
			this.type = type;
		}
		
		/**
		* Get Type Selector
		*
		* Type: typeSelectorInfoList
		*
		* Information about states and fields for a particular value of the type field.
		*/
		@Override
		public List<TypeSelectorInfo> getType()
		{
			return this.type;
		}
						
		private String objectTypeKey;
		
		/**
		* Set Object Type Identifier
		*
		* Type: objectTypeKey
		*
		* Unique identifier for an object type.
		*/
		@Override
		public void setObjectTypeKey(String objectTypeKey)
		{
			this.objectTypeKey = objectTypeKey;
		}
		
		/**
		* Get Object Type Identifier
		*
		* Type: objectTypeKey
		*
		* Unique identifier for an object type.
		*/
		@Override
		public String getObjectTypeKey()
		{
			return this.objectTypeKey;
		}
						
	}

