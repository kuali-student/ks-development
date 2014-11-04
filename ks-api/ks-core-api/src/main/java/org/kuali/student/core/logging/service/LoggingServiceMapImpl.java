/*
 * Copyright 2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.core.logging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.common.UUIDHelper;
import org.kuali.student.common.mock.MockService;
import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.core.logging.dto.LogInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.MetaInfo;
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

public class LoggingServiceMapImpl implements MockService, LoggingService {
    // cache variable 
    // The LinkedHashMap is just so the values come back in a predictable order

    private Map<String, LogInfo> logMap = new LinkedHashMap<String, LogInfo>();
    private Map<String, LogEntryInfo> logEntryMap = new LinkedHashMap<String, LogEntryInfo>();

    @Override
    public void clear() {
        this.logMap.clear();
        this.logEntryMap.clear();
    }

    @Override
    public LogInfo getLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_ID
        if (!this.logMap.containsKey(logKey)) {
            throw new DoesNotExistException(logKey);
        }
        return new LogInfo(this.logMap.get(logKey));
    }

    @Override
    public List<LogInfo> getLogsByKeys(List<String> logKeys, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_IDS
        List<LogInfo> list = new ArrayList<LogInfo>();
        for (String id : logKeys) {
            list.add(this.getLog(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getLogKeysByType(String logTypeKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_IDS_BY_TYPE
        List<String> list = new ArrayList<String>();
        for (LogInfo info : logMap.values()) {
            if (logTypeKey.equals(info.getTypeKey())) {
                list.add(info.getKey());
            }
        }
        return list;
    }

    @Override
    public List<String> searchForLogKeys(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // UNKNOWN
        throw new OperationFailedException("searchForLogKeys has not been implemented");
    }

    @Override
    public List<LogInfo> searchForLogs(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // UNKNOWN
        throw new OperationFailedException("searchForLogs has not been implemented");
    }

    @Override
    public List<ValidationResultInfo> validateLog(String validationTypeKey, String logTypeKey, LogInfo logInfo,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // VALIDATE
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    public LogInfo createLog(String key, String logTypeKey, LogInfo logInfo, ContextInfo contextInfo)
            throws
            AlreadyExistsException,
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        // CREATE
        logInfo.setKey(key);
        logInfo.setTypeKey(logTypeKey);
        try {
            LogInfo existing = this.getLog(logTypeKey, contextInfo);
            throw new AlreadyExistsException(logInfo.getKey());
        } catch (DoesNotExistException ex) {
            // ok expected
        }
        LogInfo copy = new LogInfo(logInfo);
        copy.setMeta(newMeta(contextInfo));
        logMap.put(copy.getKey(), copy);
        return new LogInfo(copy);
    }

    @Override
    public LogInfo findCreateLog(String logKey, String logTypeKey, ContextInfo contextInfo) throws DataValidationErrorException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        try {
            LogInfo log = this.getLog(logKey, contextInfo);
            if (!log.getTypeKey().equals(logTypeKey)) {
                throw new InvalidParameterException("The type of the existing log does not have the specified type");
            }
            return log;
        } catch (DoesNotExistException ex) {
            // ok create it
        }
        LogInfo log = new LogInfo();
        log.setKey(logKey);
        log.setTypeKey(logTypeKey);
        log.setStateKey(LoggingServiceTypeStateConstants.OPEN_LOG_STATE);
        log.setName(logKey);
        try {
            try {
                log = this.createLog(logKey, logTypeKey, log, contextInfo);
            } catch (AlreadyExistsException ex) {
                // someone created it after we checked but before we could create it!
                return this.findCreateLog(logKey, logTypeKey, contextInfo);
            }
        } catch (DoesNotExistException ex) {
            throw new OperationFailedException("Unexpected", ex);
        }
        return log;
    }

    @Override
    public LogInfo updateLog(String logKey, LogInfo logInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        // UPDATE
        if (!logKey.equals(logInfo.getKey())) {
            throw new InvalidParameterException("The id parameter does not match the id on the info object");
        }
        LogInfo copy = new LogInfo(logInfo);
        LogInfo old = this.getLog(logInfo.getKey(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.logMap.put(logInfo.getKey(), copy);
        return new LogInfo(copy);
    }

    @Override
    public StatusInfo deleteLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // DELETE
        if (this.logMap.remove(logKey) == null) {
            throw new OperationFailedException(logKey);
        }
        return newStatus();
    }

    @Override
    public LogEntryInfo getLogEntry(String logEntryId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_ID
        if (!this.logEntryMap.containsKey(logEntryId)) {
            throw new DoesNotExistException(logEntryId);
        }
        return new LogEntryInfo(this.logEntryMap.get(logEntryId));
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByIds(List<String> logEntryIds, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_IDS
        List<LogEntryInfo> list = new ArrayList<LogEntryInfo>();
        for (String id : logEntryIds) {
            list.add(this.getLogEntry(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getLogEntryIdsByType(String logEntryTypeKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_IDS_BY_TYPE
        List<String> list = new ArrayList<String>();
        for (LogEntryInfo info : logEntryMap.values()) {
            if (logEntryTypeKey.equals(info.getTypeKey())) {
                list.add(info.getId());
            }
        }
        return list;
    }

    @Override
    public List<String> searchForLogEntryIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // UNKNOWN
        throw new OperationFailedException("searchForLogEntryIds has not been implemented");
    }

    @Override
    public List<LogEntryInfo> searchForLogEntries(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // UNKNOWN
        throw new OperationFailedException("searchForLogEntries has not been implemented");
    }

    @Override
    public List<ValidationResultInfo> validateLogEntry(String validationTypeKey, String logEntryTypeKey, String logKey,
            LogEntryInfo logEntryInfo, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // VALIDATE
        return new ArrayList<ValidationResultInfo>();
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
        LogInfo log = this.getLog(logKey, contextInfo);
        // CREATE
        LogEntryInfo copy = new LogEntryInfo(logEntryInfo);
        copy.setLogKey(logKey);
        copy.setTypeKey(logEntryTypeKey);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        if (copy.getPrincipalId() == null) {
            copy.setPrincipalId(contextInfo.getPrincipalId());
        }
        if (copy.getTimeStamp() == null) {
            copy.setTimeStamp(contextInfo.getCurrentDate());
        }
        if (copy.getTimeStamp() == null) {
            copy.setTimeStamp(new Date());
        }
        copy.setMeta(newMeta(contextInfo));
        logEntryMap.put(copy.getId(), copy);
        return new LogEntryInfo(copy);
    }

    @Override
    public StatusInfo logEntry(String logKey,
            String logEntryTypeKey,
            String levelTypeKey,
            String logEntry,
            ContextInfo contextInfo) throws
            DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        LogEntryInfo info = new LogEntryInfo();
        info.setLogKey(logKey);
        info.setTypeKey(logEntryTypeKey);
        info.setLevelTypeKey(levelTypeKey);
        info.setStateKey(LoggingServiceTypeStateConstants.WRITTEN_LOG_ENRY_STATE);
        info.setEntry(logEntry);
        LogEntryInfo created = this.createLogEntry(logKey, logEntryTypeKey, info, contextInfo);
        return newStatus();
    }

    @Override
    public LogEntryInfo updateLogEntry(String logEntryId, LogEntryInfo logEntryInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        // UPDATE
        if (!logEntryId.equals(logEntryInfo.getId())) {
            throw new InvalidParameterException("The id parameter does not match the id on the info object");
        }
        LogEntryInfo copy = new LogEntryInfo(logEntryInfo);
        LogEntryInfo old = this.getLogEntry(logEntryInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.logEntryMap.put(logEntryInfo.getId(), copy);
        return new LogEntryInfo(copy);
    }

    @Override
    public StatusInfo deleteLogEntry(String logEntryId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // DELETE
        if (this.logEntryMap.remove(logEntryId) == null) {
            throw new OperationFailedException(logEntryId);
        }
        return newStatus();
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_INFOS_BY_OTHER
        List<LogEntryInfo> list = new ArrayList<LogEntryInfo>();
        for (LogEntryInfo info : logEntryMap.values()) {
            if (logKey.equals(info.getLogKey())) {
                list.add(new LogEntryInfo(info));
            }
        }
        return list;
    }

    private StatusInfo newStatus() {
        StatusInfo status = new StatusInfo();
        status.setSuccess(Boolean.TRUE);
        return status;
    }

    private MetaInfo newMeta(ContextInfo context) {
        MetaInfo meta = new MetaInfo();
        meta.setCreateId(context.getPrincipalId());
        meta.setCreateTime(context.getCurrentDate());
        if (meta.getCreateTime() == null) {
            meta.setCreateTime(new Date());
        }
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(meta.getCreateTime());
        if (meta.getUpdateTime() == null) {
            meta.setUpdateTime(new Date());
        }
        meta.setVersionInd("0");
        return meta;
    }

    private MetaInfo updateMeta(MetaInfo old, ContextInfo context) {
        MetaInfo meta = new MetaInfo(old);
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(context.getCurrentDate());
        if (meta.getUpdateTime() == null) {
            meta.setUpdateTime(new Date());
        }
        meta.setVersionInd((Integer.parseInt(meta.getVersionInd()) + 1) + "");
        return meta;
    }

}
