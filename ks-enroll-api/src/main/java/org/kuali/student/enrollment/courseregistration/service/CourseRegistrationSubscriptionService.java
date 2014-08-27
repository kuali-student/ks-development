package org.kuali.student.enrollment.courseregistration.service;


import org.kuali.student.enrollment.academicrecord.service.SubscriptionActionEnum;
import org.kuali.student.enrollment.courseseatcount.service.CourseSeatCountCallbackNamespaceConstants;
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
import java.util.List;

@WebService(name = "CourseRegistrationSubscriptionService", targetNamespace = CourseSeatCountCallbackNamespaceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseRegistrationSubscriptionService {

    /**
     * Subscribe a callback to listen for RegistrationRequests.
     *
     * @param action action to listen for
     * @param courseRegistrationCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, courseSeatCountCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToRegistrationRequests(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseRegistrationCallbackService") CourseRegistrationCallbackService courseRegistrationCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for RegistrationRequests by Ids.
     *
     * @param action action to listen for
     * @param registrationRequestIds the identifier for the CourseRegistration to listen for.
     * @param courseRegistrationCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, registrationRequestIds, courseSeatCountCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToRegistrationRequestsByIds(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "registrationRequestIds") List<String> registrationRequestIds,
            @WebParam(name = "courseRegistrationCallbackService") CourseRegistrationCallbackService courseRegistrationCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for RegistrationRequests by Type.
     *
     * @param action action to listen for
     * @param registrationRequestTypeKey the identifier for the RegistrationRequests type to be retrieved.
     * @param courseRegistrationCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, registrationRequestTypeKey, courseSeatCountCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToRegistrationRequestsByType(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "registrationRequestTypeKey") String registrationRequestTypeKey,
            @WebParam(name = "courseRegistrationCallbackService") CourseRegistrationCallbackService courseRegistrationCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for RegistrationRequests.
     *
     * @param action action to listen for
     * @param personId an identifier for a Person
     * @param courseRegistrationCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, personId, courseSeatCountCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToRegistrationRequestsByRequestor(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "personId") String personId,
            @WebParam(name = "courseRegistrationCallbackService") CourseRegistrationCallbackService courseRegistrationCallbackService,
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
