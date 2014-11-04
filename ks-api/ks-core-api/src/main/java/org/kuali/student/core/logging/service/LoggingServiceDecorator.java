package org.kuali.student.core.logging.service;

import java.util.List;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.core.logging.dto.LogInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.AlreadyExistsException;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;

/**
 * Base decorator for the service
 */
public class LoggingServiceDecorator implements LoggingService {

    private LoggingService nextDecorator;

    public LoggingService getNextDecorator() {
        return nextDecorator;
    }

    public void setNextDecorator(LoggingService nextDecorator) {
        this.nextDecorator = nextDecorator;
    }

    @Override
    public LogInfo getLog(String logKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLog(logKey, contextInfo);
    }

    @Override
    public List<LogInfo> getLogsByKeys(List<String> logKeys, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogsByKeys(logKeys, contextInfo);
    }

    @Override
    public List<String> getLogKeysByType(String logTypeKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogKeysByType(logTypeKey, contextInfo);
    }

    @Override
    public List<String> searchForLogKeys(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().searchForLogKeys(criteria, contextInfo);
    }

    @Override
    public List<LogInfo> searchForLogs(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().searchForLogs(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateLog(String validationTypeKey, String logTypeKey, LogInfo logInfo,
            ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().validateLog(validationTypeKey, logTypeKey, logInfo, contextInfo);
    }

    @Override
    public LogInfo createLog(String key, 
            String logTypeKey, 
            LogInfo logInfo, 
            ContextInfo contextInfo) 
            throws
            AlreadyExistsException,
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return getNextDecorator().createLog(key, logTypeKey, logInfo, contextInfo);
    }

    @Override
    public LogInfo findCreateLog(String logKey, String logTypeKey, ContextInfo contextInfo)
            throws DataValidationErrorException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return  getNextDecorator().findCreateLog(logKey, logTypeKey, contextInfo);
    }


    @Override
    public LogInfo updateLog(String logKey, LogInfo logInfo, ContextInfo contextInfo) throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        return getNextDecorator().updateLog(logKey, logInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteLog(String logKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().deleteLog(logKey, contextInfo);
    }

    @Override
    public LogEntryInfo getLogEntry(String logEntryId, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogEntry(logEntryId, contextInfo);
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByIds(List<String> logEntryIds, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogEntriesByIds(logEntryIds, contextInfo);
    }

    @Override
    public List<String> getLogEntryIdsByType(String logEntryTypeKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogEntryIdsByType(logEntryTypeKey, contextInfo);
    }

    @Override
    public List<String> searchForLogEntryIds(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().searchForLogEntryIds(criteria, contextInfo);
    }

    @Override
    public List<LogEntryInfo> searchForLogEntries(QueryByCriteria criteria, ContextInfo contextInfo) throws
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().searchForLogEntries(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateLogEntry(String validationTypeKey, String logEntryTypeKey, String logKey,
            LogEntryInfo logEntryInfo, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().validateLogEntry(validationTypeKey, logEntryTypeKey, logKey, logEntryInfo, contextInfo);
    }

    @Override
    public LogEntryInfo createLogEntry(String logKey, String logEntryTypeKey, LogEntryInfo logEntryInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return getNextDecorator().createLogEntry(logKey, logEntryTypeKey, logEntryInfo, contextInfo);
    }

    @Override
    public StatusInfo logEntry(String logKey, String logEntryTypeKey,
            String levelTypeKey, String entry, ContextInfo contextInfo)
            throws
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return getNextDecorator().logEntry(logKey, logEntryTypeKey, levelTypeKey, entry, contextInfo);
    }
    @Override
    public LogEntryInfo updateLogEntry(String logEntryId, LogEntryInfo logEntryInfo, ContextInfo contextInfo) throws
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        return getNextDecorator().updateLogEntry(logEntryId, logEntryInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteLogEntry(String logEntryId, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().deleteLogEntry(logEntryId, contextInfo);
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByLog(String logKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogEntriesByLog(logKey, contextInfo);
    }

}
