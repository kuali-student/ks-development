//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.10.29 at 10:22:39 AM PDT 
//


package org.kuali.student.enumeration.dto;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="minLength" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="maxLength" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataType",
    "minLength",
    "maxLength",
    "minOccurs",
    "maxOccurs"
})
@XmlRootElement(name = "ContextValueDescriptor")
public class ContextValueDescriptor {

    @XmlElement(required = true)
    protected String dataType;
    @XmlElement(required = true)
    protected int minLength;
    @XmlElement(required = true)
    protected int maxLength;
    @XmlElement(required = true)
    protected int minOccurs;
    @XmlElement(required = true)
    protected int maxOccurs;

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the minLength property.
     * 
     * @return
     *     possible object is
     *     {@link Bigint }
     *     
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bigint }
     *     
     */
    public void setMinLength(int value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link Bigint }
     *     
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bigint }
     *     
     */
    public void setMaxLength(int value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the minOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link Bigint }
     *     
     */
    public int getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bigint }
     *     
     */
    public void setMinOccurs(int value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link Bigint }
     *     
     */
    public int getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bigint }
     *     
     */
    public void setMaxOccurs(int value) {
        this.maxOccurs = value;
    }

}
