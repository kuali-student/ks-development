package org.kuali.student.enrollment.academicrecord.infc;

import org.kuali.rice.core.api.util.type.KualiDecimal;
import org.kuali.student.r2.common.infc.IdEntity;

import java.util.Date;
import java.util.List;

/**
 *  A StudentProgramRecord is a view on to a student's participation
 *  in a Program.
 */

public interface StudentProgramRecord 
    extends IdEntity {

    /**
     * The Id of the Student.
     *
     * @name Person Id
     * @readOnly
     * @required
     */
    public String getPersonId();

    /**
     * The Id of the canonical Program.
     *
     * @name Program Id
     */
    public String getProgramId();

    /**
     * The Id of the Program Offering in which the student is/was
     * enrolled.
     *
     * @name Program Offering Id
     */
    public String getProgramOfferingId();

    /**
     * The type of the Program.
     *
     * @name Program Type Key
     */
    public String getProgramTypeKey();

    /**
     * The program code.
     *
     * @name Program Code
     */
    public String getProgramCode();

    /**
     * The name of the Program.
     *
     * @name Program Title
     */
    public String getProgramTitle();

    /**
     * The date in which the student was admitted into the program.
     *
     * @name Admitted Date
     */
    public Date getAdmittedDate();

    /**
     * The start date of the student enrollment.
     *
     * @name Enrollment Begin Date
     */
    public Date getEnrollmentBeginDate();

    /**
     * The term Id of the first term in which the student took the
     * offering.
     *
     * @name Enrollment Begin Term Id
     */
    public String getEnrollmentBeginTermId();

    /**
     * The name of the first term in which the student took the
     * offering.
     *
     * @name Enrollment Begin Term Name
     */
    public String getEnrollmentBeginTermName();

    /**
     * The end date of the student enrollment.
     *
     * @name Enrollment End Date
     */
    public Date getEnrollmentEndDate();

    /**
     * The term Id of the last term in which the student took the
     * offering.
     *
     * @name Enrollment End Term Id
     */
    public String getEnrollmentEndTermId();

    /**
     * The name of the end term in which the student took the
     * offering.
     *
     * @name Enrollment End Term Name
     */
    public String getEnrollmentEndTermName();

    /**
     * The number of credits the student has earned in the program.
     *
     * @name Credits Earned
     */
    public KualiDecimal getCreditsEarned();

    /**
     * A label indicating the class standing of the student.
     *
     * @name Class Standing
     */
    public String getClassStanding();

    /**
     * Sub programs the student is enrolled in. For example,
     * specialization within the program.
     *
     * @name Child Programs
     */
    public List<? extends StudentProgramRecord> getChildPrograms();
}
