/**
 * Copyright 2011 The Kuali Foundation Licensed under the Educational
 * Community License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.core.scheduling.infc;

import java.util.Date;

import org.kuali.student.common.infc.HasId;
import org.kuali.student.common.infc.TimeAmount;


/**
 * Captures space and time information associated with a single
 * meeting time or event.
 * 
 * @author Kuali Student Team (Kamal)
 */

public interface MeetingTime extends HasId {

    /**
     * The date for this meeting time.
     * 
     * @name Start Time
     */
    public Date getStartTime();

    /**
     * The duration for this meeting.
     * 
     * @name Duration
     */
    public TimeAmount getDuration();

    /**
     * The room Id.
     * 
     * @name Room Id.
     */
    public String getRoomId();
}
