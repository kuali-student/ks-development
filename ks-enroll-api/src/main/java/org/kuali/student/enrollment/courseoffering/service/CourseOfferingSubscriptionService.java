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

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(name = "CourseOfferingSubscriptionService", targetNamespace = CourseOfferingSubscribeNamespaceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseOfferingSubscriptionService {
    /**
     * Subscribe a callback to listen for new CourseOfferings for any course.
     *
     * @param action action to listen for
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException courseRegistrationId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseOfferings(
            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;
    /**
     * Subscribe a callback to listen for new CourseOfferings for a given term.
     *
     * @param action action to listen for
     * @param termId the identifier for the Term to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException courseRegistrationId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseOfferingsByTerm(
            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "termId") String termId,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for a given course.
     *
     * @param action action to listen for
     * @param courseId the identifier for the Course to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException courseRegistrationId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseOfferingsByCourse(
            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseId") String courseId,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for new CourseOfferings for a given type.
     *
     * @param action action to listen for
     * @param courseOfferingTypeKey the identifier for the CourseOffering type to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException courseRegistrationId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseOfferingsByType(
            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseOfferingTypeKey") String courseOfferingTypeKey,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
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
     * @throws MissingParameterException courseRegistrationId or contextInfo is missing or null
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
