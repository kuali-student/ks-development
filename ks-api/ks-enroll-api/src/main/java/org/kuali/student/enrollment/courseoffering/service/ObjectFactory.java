
package org.kuali.student.enrollment.courseoffering.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import javax.xml.ws.wsaddressing.W3CEndpointReference;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.callback package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReturnType_QNAME = new QName(CourseOfferingCallbackNamespaceConstants.NAMESPACE, "returnType");
    private final static QName _CallbackMessage_QNAME = new QName(CourseOfferingCallbackNamespaceConstants.NAMESPACE, "callback_message");
    private final static QName _SubscribeToActivityOfferings_QNAME = new QName(CourseOfferingCallbackNamespaceConstants.NAMESPACE, "SubscribeToActivityOfferings");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.callback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, name = "returnType")
    public JAXBElement<String> createReturnType(String value) {
        return new JAXBElement<String>(_ReturnType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, name = "callback_message")
    public JAXBElement<String> createCallbackMessage(String value) {
        return new JAXBElement<String>(_CallbackMessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link javax.xml.ws.wsaddressing.W3CEndpointReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, name = "SubscribeToActivityOfferings")
    public JAXBElement<W3CEndpointReference> createSubscribeToActivityOfferings(W3CEndpointReference value) {
        return new JAXBElement<W3CEndpointReference>(_SubscribeToActivityOfferings_QNAME, W3CEndpointReference.class, null, value);
    }

}
