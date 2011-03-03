/*
 * Copyright 2009 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.enrollment.lpr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.kuali.student.core.ws.binding.JaxbAttributeMapListAdapter;

/**
 * Query to return some information regarding LUI to person relationships.
 *
 * @Author KSContractMojo
 * @Author Kamal
 * @Since Tue Mar 01 15:54:06 PST 2011
 * @See <a href="https://wiki.kuali.org/display/KULSTU/luiPersonRelationCriteria+Structure">LuiPersonRelationCriteria</a>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LuiPersonRelationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

     @XmlElement
    private String fieldKey;

    @XmlElement
    private String value;

 /**
  * Name: Field Key
  *
  * Dot path notation to identity the name of field to be compared
  */
 public String getFieldKey () {
  return fieldKey;
 }

 public void setFieldKey (String fieldKey)  {
  this.fieldKey = fieldKey;
 }


 /**
  * Name: Criteria Value
  *
  * Value to be compared
  */
 public String getValue () {
  return value;
 }

 public void setValue (String value) {
  this.value = value;
 }

    
}