/**
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
package org.kuali.student.enrollment.courseseatcount.service;

import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.enrollment.courseseatcount.dto.CourseSeatCountInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(name = "CourseSeatCountService", targetNamespace = CourseSeatCountServiceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseSeatCountService {
    /**
     * Retrieves a Course Seat Count by ID
     *
     * @param courseSeatCountId the CourseSeatCount Id
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the Person
     * @throws DoesNotExistException courseSeatCountId not found
     * @throws InvalidParameterException invalid courseSeatCountId or contextInfo
     * @throws MissingParameterException courseSeatCountId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public CourseSeatCountInfo getCourseSeatCount(

            @WebParam(name = "courseSeatCountId") String courseSeatCountId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Retrieves a list of courseSeatCounts by a list of CourseSeatCount IDs
     *
     * @param courseSeatCountIds a list of CourseSeatCount IDs
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of CourseSeatCounts
     * @throws DoesNotExistException courseSeatCountId not found
     * @throws InvalidParameterException invalid courseSeatCountId or contextInfo
     * @throws MissingParameterException courseSeatCountId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<CourseSeatCountInfo> getCourseSeatCountsByIds(

            @WebParam(name = "courseSeatCountId") List<String> courseSeatCountIds,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Gets the CourseSeatCount for a particular activity.
     *
     * @param activityOfferingId the identifier for the activityOffering that you want the seatcount.
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return CourseSeatCount.
     * @throws InvalidParameterException activityOfferingId or contextInfo is not valid
     * @throws MissingParameterException activityOfferingId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */

    public CourseSeatCountInfo getCourseSeatCountByActivityOffering(

            @WebParam(name = "activityOfferingId") String activityOfferingId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;
    /**
     * Gets the CourseSeatCount for a list of activitys.
     *
     * @param activityOfferingIds the identifier for the activityOfferings that you want the seatcounts.
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return CourseSeatCounts.
     * @throws InvalidParameterException activityOfferingId or contextInfo is not valid
     * @throws MissingParameterException activityOfferingId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<CourseSeatCountInfo> getSeatCountsByActivityOfferings(

            @WebParam(name = "activityOfferingIds") List<String> activityOfferingIds,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;
    /**
     * Retrieves a list of CourseSeatCount Ids by CourseSeatCount type.
     *
     * @param courseSeatCountTypeKey the personTypeKey to search by
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of CourseSeatCount IDs
     * @throws DoesNotExistException courseSeatCountId not found
     * @throws InvalidParameterException invalid courseSeatCountId or contextInfo
     * @throws MissingParameterException courseSeatCountId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> getCourseSeatCountIdsByType(

            @WebParam(name = "courseSeatCountTypeKey") String courseSeatCountTypeKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for CourseSeatCount Ids based on the criteria and returns a list of CourseSeatCount identifiers which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of CourseSeatCount IDs
     * @throws InvalidParameterException invalid criteria or contextInfo
     * @throws MissingParameterException courseSeatCountId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> searchForCourseSeatCountIds(

            @WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for courseSeatCounts based on the criteria and returns a list of courseSeatCounts which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of CourseSeatCount
     * @throws InvalidParameterException invalid courseSeatCountId or contextInfo
     * @throws MissingParameterException courseSeatCountId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<CourseSeatCountInfo> searchForCourseSeatCounts(

            @WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,

            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Validates a CourseSeatCount. If an identifier is present for the CourseSeatCount and a record is found for that identifier, the validation
     * checks if the CourseSeatCount can be updated to the new values. If an identifier is not present or a record does not exist, the
     * validation checks if the CourseSeatCount with the given data can be created.
     *
     * @param validationTypeKey the identifier for the validation Type
     * @param courseSeatCountTypeKey the identifier for the person type key to be validated
     * @param courseSeatCountInfo the courseSeatCount to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a list of validation results or an empty list if validation succeeded
     * @throws DoesNotExistException validationTypeKey or courseSeatCountTypeKey is not found
     * @throws InvalidParameterException courseSeatCountInfo or contextInfo is not valid
     * @throws MissingParameterException validationTypeKey, courseSeatCountTypeKey, courseSeatCountInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ValidationResultInfo> validateCourseSeatCount(

            @WebParam(name = "validationTypeKey") String validationTypeKey,
            @WebParam(name = "courseSeatCountTypeKey") String courseSeatCountTypeKey,
            @WebParam(name = "courseSeatCountInfo") CourseSeatCountInfo courseSeatCountInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Creates a new CourseSeatCount. The CourseSeatCount Id, Type, and Meta information may not be set in the supplied data.
     *
     * @param courseSeatCountTypeKey the identifier for the person type to be validated
     * @param courseSeatCountInfo the courseSeatCount to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the new CourseSeatCount
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException personTypeKey does not exist or is not supported
     * @throws InvalidParameterException personInfo or contextInfo is not valid
     * @throws MissingParameterException personTypeKey, personInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     */
    public CourseSeatCountInfo createCourseSeatCount(

            @WebParam(name = "courseSeatCountTypeKey") String courseSeatCountTypeKey,
            @WebParam(name = "courseSeatCountInfo")CourseSeatCountInfo courseSeatCountInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException;

    /**
     * Updates an existing CourseSeatCount. The CourseSeatCount Id, Type, and Meta information may not be changed.
     *
     * @param courseSeatCountId the identifier for the CourseSeatCount to be updated
     * @param courseSeatCountInfo the courseSeatCount to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the updated CourseSeatCount
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException courseSeatCountId is not found
     * @throws InvalidParameterException courseSeatCountId, courseSeatCountInfo or contextInfo is not valid
     * @throws MissingParameterException courseSeatCountId, courseSeatCountInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     * @throws VersionMismatchException if someone else has updated this courseSeatCount record since you fetched the version you are
     * updating.
     */
    public CourseSeatCountInfo updateCourseSeatCount(

            @WebParam(name = "courseSeatCountId") String courseSeatCountId,
            @WebParam(name = "courseSeatCountInfo") CourseSeatCountInfo courseSeatCountInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException;

    /**
     * Deletes an existing CourseSeatCount and all it's related parts
     *
     * @param courseSeatCountId the identifier for the courseSeatCount to be deleted
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the status of the delete operation. This must always be true.
     * @throws DoesNotExistException courseSeatCountInfo is not found
     * @throws InvalidParameterException courseSeatCountInfo or contextInfo is not valid
     * @throws MissingParameterException courseSeatCountInfo or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo deleteCourseSeatCount(

            @WebParam(name = "courseSeatCountId") String courseSeatCountId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws

            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;




}
