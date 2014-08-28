/**
 * Copyright 2014 The Kuali Foundation Licensed under the
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
 * Created by mahtabme on 8/28/14
 */
package org.kuali.student.enrollment.courseofferingset.dto;

import org.kuali.student.enrollment.courseofferingset.infc.SocRolloverConfigurationValue;
import org.kuali.student.r2.common.dto.IdNamelessEntityInfo;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * This class represents a value which was part of the "Rollover configuration" used in
 * a particular rollover.
 *
 * @author Mezba Mahtab
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SocRolloverConfigurationValueInfo",
        propOrder = {"id",
        "typeKey",
        "stateKey",
        "socRolloverResultId",
        "gesParameterKey",
        "valuePriority",
        "atpId",
        "atpTypeKey",
        "ruleId",
        "orgId",
        "cluId",
        "socId",
        "subjectCode",
        "booleanValue",
        "meta",
        "attributes",
        "_futureElements"})
public class SocRolloverConfigurationValueInfo
        extends IdNamelessEntityInfo
        implements SocRolloverConfigurationValue {

    ///////////////////////
    // CONSTANTS
    ///////////////////////

    private static final long serialVersionUID = 1L;

    ////////////////////////////////
    // DATA VARIABLES
    ////////////////////////////////

    @XmlElement
    private String socRolloverResultId;
    @XmlElement
    private String gesParameterKey;
    @XmlElement
    private Integer valuePriority;
    @XmlElement
    private String atpId;
    @XmlElement
    private String atpTypeKey;
    @XmlElement
    private String ruleId;
    @XmlElement
    private String orgId;
    @XmlElement
    private String cluId;
    @XmlElement
    private String socId;
    @XmlElement
    private String subjectCode;
    @XmlElement
    private Boolean booleanValue;
    @XmlAnyElement
    private List<Element> _futureElements;

    ////////////////////////////
    // CONSTRUCTORS
    ////////////////////////////

    public SocRolloverConfigurationValueInfo () {

    }

    public SocRolloverConfigurationValueInfo(SocRolloverConfigurationValue socRolloverConfigurationValue) {
        super(socRolloverConfigurationValue);
        if (socRolloverConfigurationValue!=null) {
            this.socRolloverResultId = socRolloverConfigurationValue.getSocRolloverResultId();
            this.gesParameterKey = socRolloverConfigurationValue.getGesParameterKey();
            this.valuePriority = socRolloverConfigurationValue.getValuePriority();
            this.atpId = socRolloverConfigurationValue.getAtpId();
            this.atpTypeKey = socRolloverConfigurationValue.getAtpTypeKey();
            this.ruleId = socRolloverConfigurationValue.getRuleId();
            this.orgId = socRolloverConfigurationValue.getOrgId();
            this.cluId = socRolloverConfigurationValue.getCluId();
            this.socId = socRolloverConfigurationValue.getSocId();
            this.subjectCode = socRolloverConfigurationValue.getSubjectCode();
            this.booleanValue = socRolloverConfigurationValue.getBooleanValue();
        }
    }

    ////////////////////////////
    // GETTERS AND SETTERS
    ////////////////////////////

    @Override
    public String getSocRolloverResultId() {
        return socRolloverResultId;
    }

    public void setSocRolloverResultId(String socRolloverResultId) {
        this.socRolloverResultId = socRolloverResultId;
    }

    @Override
    public String getGesParameterKey() {
        return gesParameterKey;
    }

    public void setGesParameterKey(String gesParameterKey) {
        this.gesParameterKey = gesParameterKey;
    }

    @Override
    public Integer getValuePriority() {
        return valuePriority;
    }

    public void setValuePriority(Integer valuePriority) {
        this.valuePriority = valuePriority;
    }

    @Override
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    @Override
    public String getAtpTypeKey() {
        return atpTypeKey;
    }

    public void setAtpTypeKey(String atpTypeKey) {
        this.atpTypeKey = atpTypeKey;
    }

    @Override
    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    @Override
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String getCluId() {
        return cluId;
    }

    public void setCluId(String cluId) {
        this.cluId = cluId;
    }

    @Override
    public String getSocId() {
        return socId;
    }

    public void setSocId(String socId) {
        this.socId = socId;
    }

    @Override
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
