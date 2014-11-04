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
package org.kuali.student.core.logging.infc;

import java.util.Date;
import org.kuali.student.r2.common.infc.IdNamelessEntity;

/**
 * An entry in the log.
 */
public interface LogEntry extends IdNamelessEntity {

    /**
     * The Key of the log to whom this entry is attached.
     *
     * @name Log Key
     * @required
     * @readOnly
     */
    public String getLogKey();

    /**
     * The level for this log entry
     *
     * @name Level Type Key
     */
    public String getLevelTypeKey();

    /**
     * Principal id of the person or system creating this log entry
     *
     * Defaults to the currently authenticated principal.
     *
     * Most of the time this will probably match the createId in the audit trail meta data.
     *
     * @name Principal Id
     */
    public String getPrincipalId();

    /**
     * The date/time this log entry relates to.
     *
     * Defaults to the current date time if not specified.
     *
     * Most of the time this should probably match the createTime inthe audit trail meta data.
     *
     * @name Time Stamp
     */
    public Date getTimeStamp();

    /**
     * The actual entry
     *
     * The format and structure of this entry is specific to the type
     *
     * @name Entry
     */
    public String getEntry();

}
