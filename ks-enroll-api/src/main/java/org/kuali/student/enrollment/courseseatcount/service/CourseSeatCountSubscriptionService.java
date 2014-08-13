package org.kuali.student.enrollment.courseseatcount.service;


import org.kuali.student.enrollment.academicrecord.service.SubscriptionActionEnum;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingCallbackService;
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

@WebService(name = "CourseSeatCountSubscriptionService", targetNamespace = CourseSeatCountSubscriptionNamespaceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseSeatCountSubscriptionService {

    /**
     * Subscribe a callback to listen for CourseSeatCounts.
     *
     * @param action action to listen for
     * @param courseSeatCountCallbackService callback executable code to be invoked when the change event executes.
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, courseSeatCountCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseSeatCounts(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseSeatCountCallbackService") CourseSeatCountCallbackService courseSeatCountCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;


    /**
     * Subscribe a callback to listen for CourseSeatCounts for the given Ids.
     *
     * @param action action to listen for
     * @param courseSeatCountId the identifier for the CourseSeatCounts to listen for.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, courseSeatCountId, courseOfferingCallbackService  or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseSeatCountsByIds(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseSeatCountId") List<String> courseSeatCountId,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;
    /**
     * Subscribe a callback to listen for CourseSeatCounts for a given ActivityOffering.
     *
     * @param action action to listen for
     * @param activityOfferingId the identifier for the ActivityOffering to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, activityOfferingId, courseOfferingCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseSeatCountsByActivityOffering(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "activityOfferingId") String activityOfferingId,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;
    /**
     * Subscribe a callback to listen for CourseSeatCounts for a given ActivityOfferings.
     *
     * @param action action to listen for
     * @param activityOfferingIds the identifier for the ActivityOffering to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, activityOfferingIds, courseOfferingCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseSeatCountsByActivityOfferings(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "activityOfferingIds") List<String> activityOfferingIds,
            @WebParam(name = "courseOfferingCallbackService") CourseOfferingCallbackService courseOfferingCallbackService,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Subscribe a callback to listen for CourseSeatCounts for a given type.
     *
     * @param action action to listen for
     * @param courseSeatCountTypeKey the identifier for the CourseSeatCount type to be retrieved.
     * @param courseOfferingCallbackService callback executable code to be invoked when the change event executes
     * @param contextInfo information containing the principalId and locale information about the caller of the service operation
     * @return callback registration id that can be used to explicitly desubscribe the listener.
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException action, courseOfferingCallbackService or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public String subscribeToCourseSeatCountsByType(

            @WebParam(name = "action") SubscriptionActionEnum action,
            @WebParam(name = "courseSeatCountTypeKey") String courseSeatCountTypeKey,
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
