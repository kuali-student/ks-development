
package org.kuali.student.rules.rulesmanagement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1.3
 * 
 */
@XmlRootElement(name = "MissingParameterException", namespace = "http://student.kuali.org/poc/wsdl/brms/rulesmanagement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MissingParameterException", namespace = "http://student.kuali.org/poc/wsdl/brms/rulesmanagement")
public class MissingParameterExceptionBean {

    private String message;

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
