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
import org.kuali.student.core.logging.infc.LogEntry;
import org.kuali.student.r2.common.dto.IdNamelessEntityInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogEntryInfo", propOrder = {"id",
    "typeKey",
    "stateKey",
    "logId",
    "levelTypeKey",
    "entry",
    "meta",
    "attributes", "_futureElements"})
public class LogEntryInfo extends IdNamelessEntityInfo implements LogEntry, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String logId;
    @XmlElement
    private String levelTypeKey;
    @XmlElement
    private String entry;

    @XmlAnyElement
    private List<Object> _futureElements;

    public LogEntryInfo() {
    }

    public LogEntryInfo(LogEntry infc) {
        super(infc);
        this.setLogId(infc.getLogId());
        this.setLevelTypeKey(infc.getLevelTypeKey());
        this.setEntry(infc.getEntry());
    }

    @Override
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Override
    public String getLevelTypeKey() {
        return levelTypeKey;
    }

    public void setLevelTypeKey(String levelTypeKey) {
        this.levelTypeKey = levelTypeKey;
    }

    @Override
    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "LogEntryInfo{" + super.toString() + ", logId=" + logId + ", levelTypeKey=" + levelTypeKey + ", entry=" + entry + '}';
    }

}
