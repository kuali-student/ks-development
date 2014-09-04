package org.kuali.student.enrollment.academicrecord.dto;

import org.kuali.rice.core.api.util.type.KualiDecimal;
import org.kuali.student.enrollment.academicrecord.infc.StudentProgramRecord;
import org.kuali.student.r2.common.dto.IdEntityInfo;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudentProgramRecordInfo", propOrder = {
                "id", "typeKey", "stateKey", "name", "descr",
                "personId", "programId", "programOfferingId",
                "programTypeKey", "programCode", "programTitle",
                "admittedDate", "enrollmentBeginDate", "enrollmentBrginTermId",
                "enrollmentBeginTermName", "enrollmentEnddate", "enrollmentEndTermId",
                "enrollmentEndTermName", "creditsEarned", "classStanding", 
                "childPrograms", "meta", "attributes", "_futureElements"})

public class StudentProgramRecordInfo 
    extends IdEntityInfo 
    implements StudentProgramRecord, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String personId;

    @XmlElement
    private String programId;

    @XmlElement
    private String programOfferingId;

    @XmlElement
    private String programTypeKey;

    @XmlElement
    private String programCode;

    @XmlElement
    private String programTitle;

    @XmlElement
    private Date admittedDate;

    @XmlElement
    private Date enrollmentBeginDate;

    @XmlElement
    private String enrollmentBeginTermId;

    @XmlElement
    private String enrollmentBeginTermName;

    @XmlElement
    private Date enrollmentEndDate;

    @XmlElement
    private String enrollmentEndTermId;

    @XmlElement
    private String enrollmentEndTermName;

    @XmlElement
    private KualiDecimal creditsEarned;

    @XmlElement
    private String classStanding;

    @XmlElement
    private List<StudentProgramRecordInfo> childPrograms;

    @XmlAnyElement
    private List<Element> _futureElements;

    
    /** 
     *  Creates a new StudentProgramRecordInfo.
     */
    public StudentProgramRecordInfo() {
    }

    /** 
     *  Creates a new StudentProgramRecordInfo from an existing
     *  StudentProgramRecord.
     *
     *  @param studentProgramRecord a StudentProgramRecord
     */

    public StudentProgramRecordInfo(StudentProgramRecord studentProgramRecord) {
        super(studentProgramRecord);

        if (studentProgramRecord != null) {
            this.personId = studentProgramRecord.getPersonId();
            this.programId = studentProgramRecord.getProgramId();
            this.programOfferingId = studentProgramRecord.getProgramOfferingId();
            this.programTypeKey = studentProgramRecord.getProgramTypeKey();
            this.programCode = studentProgramRecord.getProgramCode();
            this.programTitle = studentProgramRecord.getProgramTitle();

            if (studentProgramRecord.getAdmittedDate() != null) {
                this.admittedDate = new Date(studentProgramRecord.getAdmittedDate().getTime());
            }

            if (studentProgramRecord.getEnrollmentBeginDate() != null) {
                this.enrollmentBeginDate = new Date(studentProgramRecord.getEnrollmentBeginDate().getTime());
            }

            this.enrollmentBeginTermId = studentProgramRecord.getEnrollmentBeginTermId();
            this.enrollmentBeginTermName = studentProgramRecord.getEnrollmentBeginTermName();

            if (studentProgramRecord.getEnrollmentEndDate() != null) {
                this.enrollmentEndDate = new Date(studentProgramRecord.getEnrollmentEndDate().getTime());
            }

            this.enrollmentEndTermId = studentProgramRecord.getEnrollmentEndTermId();
            this.enrollmentEndTermName = studentProgramRecord.getEnrollmentEndTermName();

            this.creditsEarned = studentProgramRecord.getCreditsEarned();
            this.classStanding = studentProgramRecord.getClassStanding();

            if (studentProgramRecord.getChildPrograms() != null) {
                this.childPrograms = new ArrayList<StudentProgramRecordInfo>();
                for (StudentProgramRecord spr : studentProgramRecord.getChildPrograms()) {
                    this.childPrograms.add(new StudentProgramRecordInfo(spr));
                }
            }
        }
    }

    @Override
    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public String getProgramId() {
        return this.programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    @Override
    public String getProgramOfferingId() {
        return this.programOfferingId;
    }

    public void setProgramOfferingId(String programOfferingId) {
        this.programOfferingId = programOfferingId;
    }

    @Override
    public String getProgramTypeKey() {
        return this.programTypeKey;
    }

    public void setProgramTypeKey(String programTypeKey) {
        this.programTypeKey = programTypeKey;
    }

    @Override
    public String getProgramCode() {
        return this.programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    @Override
    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    @Override
    public Date getAdmittedDate() {
        return this.admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    @Override
    public Date getEnrollmentBeginDate() {
        return this.enrollmentBeginDate;
    }

    public void setEnrollmentBeginDate(Date enrollmentBeginDate) {
        this.enrollmentBeginDate = enrollmentBeginDate;
    }

    @Override
    public String getEnrollmentBeginTermId() {
        return this.enrollmentBeginTermId;
    }

    public void setEnrollmentBeginTermId(String enrollmentBeginTermId) {
        this.enrollmentBeginTermId = enrollmentBeginTermId;
    }

    @Override
    public String getEnrollmentBeginTermName() {
        return this.enrollmentBeginTermName;
    }

    public void setEnrollmentBeginTermName(String enrollmentBeginTermName) {
        this.enrollmentBeginTermName = enrollmentBeginTermName;
    }

    @Override
    public Date getEnrollmentEndDate() {
        return this.enrollmentEndDate;
    }

    public void setEnrollmentEndDate(Date enrollmentEndDate) {
        this.enrollmentEndDate = enrollmentEndDate;
    }

    @Override
    public String getEnrollmentEndTermId() {
        return this.enrollmentEndTermId;
    }

    public void setEnrollmentEndTermId(String enrollmentEndTermId) {
        this.enrollmentEndTermId = enrollmentEndTermId;
    }

    @Override
    public String getEnrollmentEndTermName() {
        return this.enrollmentEndTermName;
    }

    public void setEnrollmentEndTermName(String enrollmentEndTermName) {
        this.enrollmentEndTermName = enrollmentEndTermName;
    }

    @Override
    public String getClassStanding() {
        return this.classStanding;
    }

    public void setClassStanding(String classStanding) {
        this.classStanding = classStanding;
    }

    @Override
    public List<StudentProgramRecordInfo> getChildPrograms() {
        if (this.childPrograms == null) {
            this.childPrograms = new ArrayList<StudentProgramRecordInfo>();
        }

        return childPrograms;
    }

    public void setChildPrograms(List<StudentProgramRecordInfo> childPrograms) {
        this.childPrograms = childPrograms;
    }

    @Override
    public KualiDecimal getCreditsEarned() {
        return this.creditsEarned;
    }

    public void setCreditsEarned(KualiDecimal creditsEarned) {
        this.creditsEarned = creditsEarned;
    }
}
