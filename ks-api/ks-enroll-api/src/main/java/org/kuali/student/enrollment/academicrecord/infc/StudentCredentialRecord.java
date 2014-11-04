package org.kuali.student.enrollment.academicrecord.infc;

import org.kuali.student.r2.common.infc.IdEntity;

import java.util.Date;

/**
 * 
 */

public interface StudentCredentialRecord 
    extends IdEntity {

    /**
     * The Id of the Student.
     *
     * @name Person Id
     * @required
     * @readOnly
     */
    public String getPersonId();

    /**
     * Id of the program that was enrolled in by the student.
     *
     * @name Program Id
     */
    public String getProgramId();

    /**
     * Title of the program that was in effect at the time the student took the
     * course
     *
     * @name Program Title
     */
    public String getProgramTitle();

    /**
     * Program Code
     *
     * @name Program Code
     */
    public String getProgramCode();

    /**
     * Date the student was admitted 
     *
     * @name Date Admitted
     */
    public Date getDateAdmitted();

    /**
     * Date the student was awarded
     * 
     * @name Date Awarded
     */
    public Date getDateAwarded();

    /**
     * Awarding institution
     * 
     * @name Awarding Institution
     */
    public String getAwardingInstitution();
}
