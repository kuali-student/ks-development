
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 13:21:22 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getLuPublicationTypesForLuType", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLuPublicationTypesForLuType", namespace = "http://student.kuali.org/wsdl/lu")

public class GetLuPublicationTypesForLuType {

    @XmlElement(name = "luTypeKey")
    private java.lang.String luTypeKey;

    public java.lang.String getLuTypeKey() {
        return this.luTypeKey;
    }

    public void setLuTypeKey(java.lang.String newLuTypeKey)  {
        this.luTypeKey = newLuTypeKey;
    }

}

