
package org.kuali.student.brms.rulemanagement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.brms.rulemanagement.dto.BusinessRuleInfo;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Apr 07 16:13:12 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getBusinessRuleByAnchorListResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleManagement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBusinessRuleByAnchorListResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleManagement")

public class GetBusinessRuleByAnchorListResponse {

    @XmlElement(name = "return")
    private java.util.List<BusinessRuleInfo> _return;

    public java.util.List<BusinessRuleInfo> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.List<BusinessRuleInfo> new_return)  {
        this._return = new_return;
    }

}

