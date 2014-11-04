/*
 * Copyright 2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.enrollment.courseoffering.service;

import org.kuali.student.enrollment.academicrecord.service.SubscriptionActionEnum;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import java.util.List;


@WebService(name = "CourseOfferingSubscriptionService", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public interface CourseOfferingSubscriptionService {

    /**
     * Subscribe a callback to listen for ActivityOfferings for any Activity.
     *
     * @param action action to listen for
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToActivityOfferings")
    public String subscribeToActivityOfferings(@WebParam(partName = "callback_action", name = "SubscribeToActivityOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                               @WebParam(partName = "callback_object", name = "SubscribeToActivityOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                               @WebParam(partName = "callback_context", name = "SubscribeToActivityOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE)ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new ActivityOfferings for a given term.
     *
     * @param action action to listen for
     * @param termId the identifier for the Term to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToActivityOfferingsByTerm")
    public String subscribeToActivityOfferingsByTerm(@WebParam(partName = "callback_action", name = "SubscribeToActivityOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                     @WebParam(partName = "callback_term_id", name = "SubscribeToActivityOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String termId,
                                                     @WebParam(partName = "callback_object", name = "SubscribeToActivityOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                     @WebParam(partName = "callback_context", name = "SubscribeToActivityOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new ActivityOfferings for a given activity.
     *
     * @param action action to listen for
     * @param activityId the identifier for the Activity to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToActivityOfferingsByActivity")
    public String subscribeToActivityOfferingsByActivity(@WebParam(partName = "callback_action", name = "SubscribeToActivityOfferingsByActivity", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                         @WebParam(partName = "callback_activity_id", name = "SubscribeToActivityOfferingsByActivity", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String activityId,
                                                         @WebParam(partName = "callback_object", name = "SubscribeToActivityOfferingsByActivity", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                         @WebParam(partName = "callback_context", name = "SubscribeToActivityOfferingsByActivity", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for ActivityOfferings by type.
     *
     * @param action action to listen for
     * @param activityOfferingTypeKey the identifier for the ActivityOffering type to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToActivityOfferingsByType")
    public String subscribeToActivityOfferingsByType(@WebParam(partName = "callback_action", name = "SubscribeToActivityOfferingsByType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                     @WebParam(partName = "callback_activity_type_key", name = "SubscribeToActivityOfferingsByType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String activityOfferingTypeKey,
                                                     @WebParam(partName = "callback_object", name = "SubscribeToActivityOfferingsByType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                     @WebParam(partName = "callback_context", name = "SubscribeToActivityOfferingsByType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for any course.
     *
     * @param action action to listen for
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToCourseOfferings")
    public String subscribeToCourseOfferings(@WebParam(partName = "callback_action", name = "SubscribeToCourseOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                             @WebParam(partName = "callback_object", name = "SubscribeToCourseOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                             @WebParam(partName = "callback_context", name = "SubscribeToCourseOfferings", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for any course.
     *
     * @param action action to listen for
     * @param courseOfferingIds a list of CourseOffering identifiers to
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToCourseOfferingsByIds")
    public String subscribeToCourseOfferingsByIds(@WebParam(partName = "callback_action", name = "SubscribeToCourseOfferingsByIds", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                  @WebParam(partName = "callback_course_offering_ids", name = "SubscribeToCourseOfferingsByIds", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) List<String> courseOfferingIds,
                                                  @WebParam(partName = "callback_object", name = "SubscribeToCourseOfferingsByIds", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                  @WebParam(partName = "callback_context", name = "SubscribeToCourseOfferingsByIds", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for a given term.
     *
     * @param action action to listen for
     * @param termId the identifier for the Term to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToCourseOfferingsByTerm")
    public String subscribeToCourseOfferingsByTerm(@WebParam(partName = "callback_action", name = "SubscribeToCourseOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                   @WebParam(partName = "callback_term_id", name = "SubscribeToCourseOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String termId,
                                                   @WebParam(partName = "callback_object", name = "SubscribeToCourseOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                   @WebParam(partName = "callback_context", name = "SubscribeToCourseOfferingsByTerm", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for a given course.
     *
     * @param action action to listen for
     * @param courseId the identifier for the Course to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToCourseOfferingsByCourse")
    public String subscribeToCourseOfferingsByCourse(@WebParam(partName = "callback_action", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                     @WebParam(partName = "callback_course_id", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String courseId,
                                                     @WebParam(partName = "callback_object", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                     @WebParam(partName = "callback_context", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for a given type.
     *
     * @param action action to listen for
     * @param courseOfferingTypeKey the identifier for the CourseOffering type to be retrieved.
     * @param W3CEndpointReference callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException a parameter is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    @WebResult(name = "returnType", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE, partName = "the_return")
    @WebMethod(operationName = "SubscribeToCourseOfferingsByType")
    public String subscribeToCourseOfferingsByType(@WebParam(partName = "callback_action", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) SubscriptionActionEnum action,
                                                   @WebParam(partName = "callback_course_offering_type_key", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) String courseOfferingTypeKey,
                                                   @WebParam(partName = "callback_object", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) W3CEndpointReference callbackObject,
                                                   @WebParam(partName = "callback_context", name = "SubscribeToCourseOfferingsByCourse", targetNamespace = CourseOfferingCallbackNamespaceConstants.NAMESPACE) ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Remove the subscription of callback to stop listening.
     *
     * @param subscriptionId the identifier for the subscription
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return status indicating if it it unsubscribed
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException courseRegistrationId is not found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException subscriptionId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo removeSubscription(
            @WebParam(name = "subscriptionId") String subscriptionId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;



}
