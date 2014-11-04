/*
 * Copyright 2013 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.core.logging.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import org.kuali.student.core.logging.infc.Log;
import org.kuali.student.r2.common.dto.KeyEntityInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogInfo", propOrder = {"key",
    "typeKey",
    "stateKey",
    "levelTypeKey",
    "name",
    "descr",
    "meta",
    "attributes", "_futureElements"})
public class LogInfo extends KeyEntityInfo implements Log, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String levelTypeKey;
    @XmlAnyElement
    private List<Object> _futureElements;

    public LogInfo() {

    }

    public LogInfo(Log input) {
        super(input);
        this.setLevelTypeKey(input.getLevelTypeKey());
    }

    @Override
    public String getLevelTypeKey() {
        return levelTypeKey;
    }

    public void setLevelTypeKey(String levelTypeKey) {
        this.levelTypeKey = levelTypeKey;
    }

    @Override
    public String toString() {
        return "LogInfo{" + super.toString() + ", levelTypeKey=" + levelTypeKey + '}';
    }
    
    
}
