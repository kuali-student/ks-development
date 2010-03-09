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
package org.kuali.student.service.lo.dev.api;


import java.util.Date;
import java.util.Map;


public interface LoLoRelationInfo
{
	
	/**
	* Set LO Identifier
	*
	* Type: loId
	*
	* Unique identifier for a learning objective record. This is the "From" or 
	* "Parent" in the relation.
	*/
	public void setLoId(String loId);
	
	/**
	* Get LO Identifier
	*
	* Type: loId
	*
	* Unique identifier for a learning objective record. This is the "From" or 
	* "Parent" in the relation.
	*/
	public String getLoId();
	
	
	
	/**
	* Set Related LO Identifier
	*
	* Type: loId
	*
	* Unique identifier for a learning objective record. This is the "To" or "Child" 
	* of the relation.
	*/
	public void setRelatedLoId(String relatedLoId);
	
	/**
	* Get Related LO Identifier
	*
	* Type: loId
	*
	* Unique identifier for a learning objective record. This is the "To" or "Child" 
	* of the relation.
	*/
	public String getRelatedLoId();
	
	
	
	/**
	* Set Effective Date
	*
	* Type: dateTime
	*
	* Date and time that this LO to LO relationship became effective. This is a 
	* similar concept to the effective date on enumerated values. When an expiration 
	* date has been specified, this field must be less than or equal to the expiration 
	* date.
	*/
	public void setEffectiveDate(Date effectiveDate);
	
	/**
	* Get Effective Date
	*
	* Type: dateTime
	*
	* Date and time that this LO to LO relationship became effective. This is a 
	* similar concept to the effective date on enumerated values. When an expiration 
	* date has been specified, this field must be less than or equal to the expiration 
	* date.
	*/
	public Date getEffectiveDate();
	
	
	
	/**
	* Set Expiration Date
	*
	* Type: dateTime
	*
	* Date and time that this LO to LO relationship expires. This is a similar concept 
	* to the expiration date on enumerated values. If specified, this should be 
	* greater than or equal to the effective date. If this field is not specified, 
	* then no expiration date has been currently defined and should automatically be 
	* considered greater than the effective date.
	*/
	public void setExpirationDate(Date expirationDate);
	
	/**
	* Get Expiration Date
	*
	* Type: dateTime
	*
	* Date and time that this LO to LO relationship expires. This is a similar concept 
	* to the expiration date on enumerated values. If specified, this should be 
	* greater than or equal to the effective date. If this field is not specified, 
	* then no expiration date has been currently defined and should automatically be 
	* considered greater than the effective date.
	*/
	public Date getExpirationDate();
	
	
	
	/**
	* Set Generic/dynamic attributes
	*
	* Type: attributeInfoList
	*
	* List of key/value pairs, typically used for dynamic attributes.
	*/
	public void setAttributes(Map<String,String> attributes);
	
	/**
	* Get Generic/dynamic attributes
	*
	* Type: attributeInfoList
	*
	* List of key/value pairs, typically used for dynamic attributes.
	*/
	public Map<String,String> getAttributes();
	
	
	
	/**
	* Set Create/Update meta info
	*
	* Type: metaInfo
	*
	* Create and last update info for the structure. This is optional and treated as 
	* read only since the data is set by the internals of the service during 
	* maintenance operations.
	*/
	public void setMetaInfo(MetaInfo metaInfo);
	
	/**
	* Get Create/Update meta info
	*
	* Type: metaInfo
	*
	* Create and last update info for the structure. This is optional and treated as 
	* read only since the data is set by the internals of the service during 
	* maintenance operations.
	*/
	public MetaInfo getMetaInfo();
	
	
	
	/**
	* Set LO to LO Relation Type
	*
	* Type: loLoRelationTypeKey
	*
	* Unique identifier for the LO to LO relation type.
	*/
	public void setType(String type);
	
	/**
	* Get LO to LO Relation Type
	*
	* Type: loLoRelationTypeKey
	*
	* Unique identifier for the LO to LO relation type.
	*/
	public String getType();
	
	
	
	/**
	* Set LO to LO Relation State
	*
	* Type: string
	*
	* Identifier for the current status of a LO to LO relationship. The values for 
	* this field are constrained to those in the luLuRelationState enumeration. A 
	* separate setup operation does not exist for retrieval of the meta data around 
	* this value.
	*/
	public void setState(String state);
	
	/**
	* Get LO to LO Relation State
	*
	* Type: string
	*
	* Identifier for the current status of a LO to LO relationship. The values for 
	* this field are constrained to those in the luLuRelationState enumeration. A 
	* separate setup operation does not exist for retrieval of the meta data around 
	* this value.
	*/
	public String getState();
	
	
	
	/**
	* Set LO to LO Relation Identifier
	*
	* Type: loLoRelationId
	*
	* Unique identifier for a LO to LO relationship. This is optional, due to the 
	* identifier being set at the time of creation. Once the relation has been 
	* created, this should be seen as required.
	*/
	public void setId(String id);
	
	/**
	* Get LO to LO Relation Identifier
	*
	* Type: loLoRelationId
	*
	* Unique identifier for a LO to LO relationship. This is optional, due to the 
	* identifier being set at the time of creation. Once the relation has been 
	* created, this should be seen as required.
	*/
	public String getId();
	
	
	
}

