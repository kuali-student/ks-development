
package org.kuali.student.core.statement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed May 12 12:54:47 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getRefStatementRelationTypesForRefObjectSubType", namespace = "http://student.kuali.org/wsdl/statement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRefStatementRelationTypesForRefObjectSubType", namespace = "http://student.kuali.org/wsdl/statement")

public class GetRefStatementRelationTypesForRefObjectSubType {

    @XmlElement(name = "refSubTypeKey")
    private java.lang.String refSubTypeKey;

    public java.lang.String getRefSubTypeKey() {
        return this.refSubTypeKey;
    }

    public void setRefSubTypeKey(java.lang.String newRefSubTypeKey)  {
        this.refSubTypeKey = newRefSubTypeKey;
    }

}

