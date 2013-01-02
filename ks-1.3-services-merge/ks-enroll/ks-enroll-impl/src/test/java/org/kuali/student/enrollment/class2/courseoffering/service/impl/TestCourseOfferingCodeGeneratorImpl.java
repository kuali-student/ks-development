/**
 * Copyright 2012 The Kuali Foundation Licensed under the
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
 *
 * Created by Daniel on 6/7/12
 */
package org.kuali.student.enrollment.class2.courseoffering.service.impl;

import org.junit.Test;
import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class //TODO ...
 *
 * @author Kuali Student Team
 */
public class TestCourseOfferingCodeGeneratorImpl {

    @Test
    public void testGenerator(){
        CourseOfferingCodeGeneratorImpl impl = new CourseOfferingCodeGeneratorImpl();
        String code;
        code = impl.generateActivityOfferingCode(new ArrayList<ActivityOfferingInfo>());
        assertEquals("A",code);

        List<ActivityOfferingInfo> aos = new ArrayList<ActivityOfferingInfo>();
        for(char c='A';c<='Z';c++){
            ActivityOfferingInfo a = new ActivityOfferingInfo();
            a.setActivityCode(String.valueOf(c));
            aos.add(a);
        }
        code = impl.generateActivityOfferingCode(aos);
        assertEquals("AA",code);

        aos.remove(3);

        code = impl.generateActivityOfferingCode(aos);
        assertEquals("D",code);

    }
}
