package org.kuali.student.core.logging.service;

import java.util.List;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.core.logging.dto.LogInfo;
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
    public LogInfo getLog(String logId, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLog(logId, contextInfo);
    }

    @Override
    public List<LogInfo> getLogsByIds(List<String> logIds, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogsByIds(logIds, contextInfo);
    }

    @Override
    public List<String> getLogIdsByType(String logTypeKey, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogIdsByType(logTypeKey, contextInfo);
    }

    @Override
    public List<String> searchForLogIds(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().searchForLogIds(criteria, contextInfo);
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
    public LogInfo createLog(String logTypeKey, LogInfo logInfo, ContextInfo contextInfo) throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return getNextDecorator().createLog(logTypeKey, logInfo, contextInfo);
    }

    @Override
    public LogInfo updateLog(String logId, LogInfo logInfo, ContextInfo contextInfo) throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        return getNextDecorator().updateLog(logId, logInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteLog(String logId, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().deleteLog(logId, contextInfo);
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
    public List<ValidationResultInfo> validateLogEntry(String validationTypeKey, String logEntryTypeKey, String logId,
            LogEntryInfo logEntryInfo, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().validateLogEntry(validationTypeKey, logEntryTypeKey, logId, logEntryInfo, contextInfo);
    }

    @Override
    public LogEntryInfo createLogEntry(String logEntryTypeKey, String logId, LogEntryInfo logEntryInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        return getNextDecorator().createLogEntry(logEntryTypeKey, logId, logEntryInfo, contextInfo);
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
    public List<LogEntryInfo> getLogEntriesByLog(String logId, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return getNextDecorator().getLogEntriesByLog(logId, contextInfo);
    }

}
