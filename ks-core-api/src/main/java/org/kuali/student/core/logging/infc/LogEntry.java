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

import org.kuali.student.r2.common.infc.IdNamelessEntity;

/**
 * An entry in the log.
 */
public interface LogEntry extends IdNamelessEntity {
    
    
    /**
     * The id of the log to whom this entry is attached.
     * 
     * @name Log Id
     * @required
     * @readOnly
     */
    public String getLogId();
    
     /**
     * The level for this log entry
     * 
     * @name Level Type Key
     */
    public String getLevelTypeKey();
    
    /**
     * The actual entry
     * 
     * The format and structure of this entry is specific to the type
     *  
     * @name Entry
     * @required
     */
    public String getEntry();

  

}
