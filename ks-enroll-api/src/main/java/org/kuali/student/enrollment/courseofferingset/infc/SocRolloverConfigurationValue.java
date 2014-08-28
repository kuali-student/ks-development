package org.kuali.student.enrollment.courseofferingset.infc;

import org.kuali.student.r2.common.infc.IdNamelessEntity;

/**
 * Read only object that holds a rule (a GES value) that was used as part of the
 * "Rollover configuration" which applied to this rollover.
 *
 * @author Mezba Mahtab
 */
public interface SocRolloverConfigurationValue
    extends IdNamelessEntity {

    /**
     * The id of the rollover result to which this item belongs
     *
     * @name Soc Rollover Result Id
     * @readOnly
     * @required
     */
    public String getSocRolloverResultId();

    /**
     * The GES parameter associated with this value.
     * @name Parameter Key
     * @readOnly
     * @required
     */
    public String getGesParameterKey();

    /**
     *  An Integer that set the priority of the GES value relative to other values associated with
     *  a specific parameter.
     * @name Priority
     * @readOnly
     */
    public Integer getValuePriority();

    /**
     * An optional id for an ATP if the value was restricted for a specific term.
     * @readOnly
     */
    public String getAtpId();

    /**
     *  An ATP type key that restricts the applicability of value.
     * @name ATP Type Key
     * @readOnly
     */
    public String getAtpTypeKey();

    /**
     * An optional Rule Id that restricted the applicability of this value.
     * @name Rule Id
     * @readOnly
     */
    public String getRuleId();

    /**
     * An optional Organization Id that restricts the applicability of this value.
     * @name Org Id
     * @readOnly
     */
    public String getOrgId();

    /**
     * An optional CLU (Canonical Learning Unit) Id that restricted the applicability of this value.
     * @name CLU ID
     * @readOnly
     */
    public String getCluId();

    /**
     * An optional SOC (Set of Courses) Id that restricted the applicability of this value.
     * @name SOC ID
     * @readOnly
     */
    public String getSocId();

    /**
     * An optional Subject Code that restricted the applicability of this value.
     * @name Subject Code
     * @readOnly
     */
    public String getSubjectCode();

    /**
     * The Boolean value contained within this value.
     * @name Boolean Value
     * @readOnly
     */
    public Boolean getBooleanValue();

}
