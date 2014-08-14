/*
 * Copyright 2013 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.core.logging.service;

import org.kuali.rice.core.api.criteria.QueryByCriteria;
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
import org.kuali.student.core.logging.dto.LogInfo;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import javax.jws.WebParam;
import org.kuali.student.core.logging.dto.LogEntryInfo;

/**
 * Log Service provides access to people.
 */
@WebService(name = "LoggingService", targetNamespace = LoggingServiceNamespace.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface LoggingService {

    /**
     * Retrieves a Log by a Log ID
     *
     * @param logId the Log ID
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the Log
     * @throws DoesNotExistException logId not found
     * @throws InvalidParameterException invalid logId or contextInfo
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public LogInfo getLog(@WebParam(name = "logId") String logId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Retrieves a list of logs by a list of Log IDs
     *
     * @param logIds a list of Log IDs
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of People
     * @throws DoesNotExistException logId not found
     * @throws InvalidParameterException invalid logId or contextInfo
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<LogInfo> getLogsByIds(@WebParam(name = "logIds") List<String> logIds,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Retrieves a list of Log Ids by log type.
     *
     * @param logTypeKey the logTypeKey to search by
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of Log IDs
     * @throws DoesNotExistException logId not found
     * @throws InvalidParameterException invalid logId or contextInfo
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> getLogIdsByType(@WebParam(name = "logTypeKey") String logTypeKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for Log Ids based on the criteria and returns a list of Log entries which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of Log IDs
     * @throws InvalidParameterException invalid criteria or contextInfo
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> searchForLogIds(@WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for logs based on the criteria and returns a list of logs which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of People
     * @throws InvalidParameterException invalid logId or contextInfo
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<LogInfo> searchForLogs(@WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws 
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Validates a Log. If an entry is present for the Log and a record is found for that entry, the validation
     * checks if the Log can be updated to the new values. If an entry is not present or a record does not exist, the
     * validation checks if the log with the given data can be created.
     *
     * @param validationTypeKey the entry for the validation Type
     * @param logTypeKey the entry for the log type key to be validated
     * @param logInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a list of validation results or an empty list if validation succeeded
     * @throws DoesNotExistException validationTypeKey or logTypeKey is not found
     * @throws InvalidParameterException logInfo or contextInfo is not valid
     * @throws MissingParameterException validationTypeKey, logTypeKey, logInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ValidationResultInfo> validateLog(@WebParam(name = "validationTypeKey") String validationTypeKey,
            @WebParam(name = "logTypeKey") String logTypeKey,
            @WebParam(name = "logInfo") LogInfo logInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Creates a new Log. The Log Id, Type, and Meta information may not be set in the supplied data.
     *
     * @param logTypeKey the entry for the log type to be validated
     * @param logInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the new Log
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException logTypeKey does not exist or is not supported
     * @throws InvalidParameterException logInfo or contextInfo is not valid
     * @throws MissingParameterException logTypeKey, logInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     */
    public LogInfo createLog(@WebParam(name = "logTypeKey") String logTypeKey,
            @WebParam(name = "logInfo") LogInfo logInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException;

    /**
     * Updates an existing Log. The Log Id, Type, and Meta information may not be changed.
     *
     * @param logId the entry for the Log to be updated
     * @param logInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the updated Log
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException logId is not found
     * @throws InvalidParameterException logId, logInfo or contextInfo is not valid
     * @throws MissingParameterException logId, logInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     * @throws VersionMismatchException if someone else has updated this log record since you fetched the version you are
     * updating.
     */
    public LogInfo updateLog(@WebParam(name = "logId") String logId,
            @WebParam(name = "logInfo") LogInfo logInfo,
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
     * Deletes an existing Log and all it's related parts
     *
     * @param logId the entry for the log to be deleted
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the status of the delete operation. This must always be true.
     * @throws DoesNotExistException logInfo is not found
     * @throws InvalidParameterException logInfo or contextInfo is not valid
     * @throws MissingParameterException logInfo or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo deleteLog(@WebParam(name = "logId") String logId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

   

    ////
    //// log entries
    ////
    /**
     * Retrieves a Log Entry by a Log Entry ID
     *
     * @param logEntryId the Log Entry ID
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the LogEntry
     * @throws DoesNotExistException logEntryId not found
     * @throws InvalidParameterException invalid logEntryId or contextInfo
     * @throws MissingParameterException logEntryId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public LogEntryInfo getLogEntry(@WebParam(name = "logEntryId") String logEntryId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Retrieves a list of log entries by a list of Log Entry IDs
     *
     * @param logEntryIds a list of Log Entry IDs
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of Log Entries
     * @throws DoesNotExistException logEntryId not found
     * @throws InvalidParameterException invalid logEntryId or contextInfo
     * @throws MissingParameterException logEntryId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<LogEntryInfo> getLogEntriesByIds(
            @WebParam(name = "logEntryIds") List<String> logEntryIds,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Retrieves a list of Log Entry Ids by log type.
     *
     * @param logEntryTypeKey the logEntry Type Key to search by
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of LogEntry IDs
     * @throws DoesNotExistException logEntryTypeKey not found
     * @throws InvalidParameterException invalid logEntryTypeKey or contextInfo
     * @throws MissingParameterException logEntryTypeKey or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> getLogEntryIdsByType(@WebParam(name = "logEntryTypeKey") String logEntryTypeKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for Log Entry Ids based on the criteria and returns a list of Log Entry entries which match
     * the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of LogEntry IDs
     * @throws InvalidParameterException invalid criteria or contextInfo
     * @throws MissingParameterException criteria or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> searchForLogEntryIds(@WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Searches for log entries based on the criteria and returns a list of logs which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a List of Log Entries
     * @throws InvalidParameterException invalid criteria or contextInfo
     * @throws MissingParameterException criteria or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<LogEntryInfo> searchForLogEntries(@WebParam(name = "criteria") QueryByCriteria criteria,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Validates a LogEntry. If an entry is present for the Log Entry and a record is found for that
     * entry, the validation checks if the LogEntry can be updated to the new values. If an entry is not present
     * or a record does not exist, the validation checks if the log with the given data can be created.
     *
     * @param validationTypeKey the entry for the validation Type
     * @param logEntryTypeKey the entry for the log entry type to be validated
     * @param logId id of log for whom this entry is being applied
     * @param logEntryInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return a list of validation results or an empty list if validation succeeded
     * @throws DoesNotExistException validationTypeKey or logEntryTypeKey is not found
     * @throws InvalidParameterException logEntryInfo or contextInfo is not valid
     * @throws MissingParameterException validationTypeKey, logEntryTypeKey, logEntryInfo, or contextInfo is
     * missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ValidationResultInfo> validateLogEntry(@WebParam(name = "validationTypeKey") String validationTypeKey,
            @WebParam(name = "logEntryTypeKey") String logEntryTypeKey,
            @WebParam(name = "logId") String logId,
            @WebParam(name = "logEntryInfo") LogEntryInfo logEntryInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Creates a new Log Entry. The Log Entry Id, Type, and Meta information may not be set in the supplied data.
     *
     * @param logEntryTypeKey the entry for the log entry Type to assign to this entry object
     * @param logId id of the log to whom this entry is attached
     * @param logEntryInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the new LogEntry
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException logEntryType does not exist or is not supported
     * @throws InvalidParameterException logInfo or contextInfo is not valid
     * @throws MissingParameterException logEntryType, logEntryInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     */
    public LogEntryInfo createLogEntry(@WebParam(name = "logEntryTypeKey") String logEntryTypeKey,
            @WebParam(name = "logId") String logId,
            @WebParam(name = "logEntryInfo") LogEntryInfo logEntryInfo,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException;

    /**
     * Updates an existing Log Entry. The Log Entry Id, Type, and Meta information may not be changed.
     *
     * @param logEntryId the entry for the LogEntry to be updated
     * @param logEntryInfo the log to be validated
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the updated LogEntry
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException logId is not found
     * @throws InvalidParameterException logId, logEntryInfo or contextInfo is not valid
     * @throws MissingParameterException logId, logEntryInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information designated as read only
     * @throws VersionMismatchException if someone else has updated this log record since you fetched the version you are
     * updating.
     */
    public LogEntryInfo updateLogEntry(@WebParam(name = "logEntryId") String logEntryId,
            @WebParam(name = "logEntryInfo") LogEntryInfo logEntryInfo,
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
     * Deletes an existing Log Entry.
     *
     * @param logEntryId the entry for the log entry record to be deleted
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return the status of the delete operation. This must always be true.
     * @throws DoesNotExistException logEntryId is not found
     * @throws InvalidParameterException logEntryId or contextInfo is not valid
     * @throws MissingParameterException logEntryId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo deleteLogEntry(@WebParam(name = "logEntryId") String logEntryId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    /**
     * Get log entries for a log
     *
     * @param logId the entry for the log
     * @param contextInfo Context information containing the principalId and locale information about the caller of service
     * operation
     * @return list of entries for that log
     * @throws DoesNotExistException logId is not found
     * @throws InvalidParameterException logId or contextInfo is not valid
     * @throws MissingParameterException logId or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<LogEntryInfo> getLogEntriesByLog(@WebParam(name = "logId") String logId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo) throws
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;


}
