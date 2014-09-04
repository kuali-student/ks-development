/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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

package org.kuali.student.enrollment.academicrecord.infc;

import org.kuali.student.r2.common.infc.IdNamelessEntity;

import java.util.Date;

/**
 * Information about a Student Course Record. A Student Course Record
 * contains information on the courses a student has taken.
 *
 * include notes on Id
 *
 * @author tom
 * @since Tue Sep 06 14:22:34 EDT 2011
 */ 

public interface StudentCourseRecord 
    extends IdNamelessEntity {

    /**
     * The Id of the Student.
     *
     * @name Person Id
     * @required
     * @readOnly
     */
    public String getPersonId();

    /**
     * Id of the course that was taken by the student
     *
     * @name Course Offering Id
     */
    public String getCourseOfferingId();

    /**
     *  The Source is represented by a Type to indicate what crated
     *  this record. Examples are "native" that implies the exietence
     *  of a Course Registration or a "transfer articulation" that may
     *  imply the existence of other data. 
     *
     *  @notes should be the Type of StudentCourseRecord?
     *
     *  @name Source Type Key
     */
    public String getSourceTypeKey();

    /**
     * The Id of the Course Registration. A Course Registration Id is
     * available for native source types.
     *
     * @name Course Registration Id
     */
    public String getCourseRegistrationId();

    /**
     * The title of the course that was in effect at the time
     * the student took the course. 
     *
     * @name Course Title
     */
    public String getCourseTitle();

    /**
     * The code or number of the course that was in effect at the time
     * the student took the course. 
     *
     * @name Course Code
     */
    public String getCourseCode();

    /**
     * The code or number of the primary activity or section that was
     * in effect at the time the student took the course. ???
     *
     * @name Activity Code
     */
    public String getActivityCode();

    /**
     * The term Id of the term in which the student took the offering.
     *
     * @name Term Id
     */
    public String getTermId();

    /**
     * The name of the term in which the student took the offering.
     *
     * @name Term Name
     */
    public String getTermName();

    /**
     * The start date of the course.
     *
     * @name Course Begin Date
     */
    public Date getCourseBeginDate();

    /**
     * The end date of the course.
     *
     * @name Course End Date
     */
    public Date getCourseEndDate();

    /**
     * The grade the student was assigned for the course.
     *
     * @name Assigned Grade Value
     */
    public String getAssignedGradeValue();

    /**
     * The Id for the grading scale for the assigned grade.
     *
     * @name Assigned Grade Scale Key
     */
    public String getAssignedGradeScaleKey();

    /**
     * The grade the student was assigned for the course.
     *
     * @name Administrative Grade Value Key
     */
    public String getAdministrativeGradeValue();

    /**
     * The Id for the grading scale for the administrative grade.
     *
     * @name Administrative Grade Scale Key
     */
    public String getAdministrativeGradeScaleKey();

    /**
     * The calculated grade the student earned for the course.
     *
     * @name Calculated Grade Value
     */
    public String getCalculatedGradeValue();

    /**
     * The Id for the grading scale for the calculated grade.
     *
     * @name Calculated Grade Scale Key
     */
    public String getCalculatedGradeScaleKey();

    /**
     * The number of credits the student attempted for this course.
     *
     * @return a string representing a floating point decimal number
     * @name Credits Attempted
     */
    public String getCreditsAttempted();

    /**
     * The number of credits the student earned for this course.
     *
     * @return a string representing a floating point decimal number
     * @name Credits Earned
     */
    public String getCreditsEarned();

    /**
     * The number of credits to be applied for the GPA calculation.
     * This is provides a weighting to this course for the GPA.
     *
     * @return a string representing a floating point decimal number
     * @name Credits For GPA
     */
    public String getCreditsForGPA();

    /**
     * If this student record counts toward the cumultive credits.
     *
     * @name Counts Toward Credits
     */
    public Boolean getCountsTowardCredits();

    /**
     * If this course is a repeat of a previous offering. the student
     * took.
     *
     * @name Is Repeated
     */
    public Boolean getIsRepeated();
}
