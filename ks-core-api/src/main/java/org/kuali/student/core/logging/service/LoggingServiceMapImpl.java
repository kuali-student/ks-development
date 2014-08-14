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
    public LogInfo getLog(String logId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_ID
        if (!this.logMap.containsKey(logId)) {
            throw new DoesNotExistException(logId);
        }
        return new LogInfo(this.logMap.get(logId));
    }

    @Override
    public List<LogInfo> getLogsByIds(List<String> logIds, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_BY_IDS
        List<LogInfo> list = new ArrayList<LogInfo>();
        for (String id : logIds) {
            list.add(this.getLog(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getLogIdsByType(String logTypeKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_IDS_BY_TYPE
        List<String> list = new ArrayList<String>();
        for (LogInfo info : logMap.values()) {
            if (logTypeKey.equals(info.getTypeKey())) {
                list.add(info.getId());
            }
        }
        return list;
    }

    @Override
    public List<String> searchForLogIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // UNKNOWN
        throw new OperationFailedException("searchForLogIds has not been implemented");
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
    public LogInfo createLog(String logTypeKey, LogInfo logInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        // CREATE
        if (!logTypeKey.equals(logInfo.getTypeKey())) {
            throw new InvalidParameterException("The type parameter does not match the type on the info object");
        }
        LogInfo copy = new LogInfo(logInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        logMap.put(copy.getId(), copy);
        return new LogInfo(copy);
    }

    @Override
    public LogInfo updateLog(String logId, LogInfo logInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException,
            VersionMismatchException {
        // UPDATE
        if (!logId.equals(logInfo.getId())) {
            throw new InvalidParameterException("The id parameter does not match the id on the info object");
        }
        LogInfo copy = new LogInfo(logInfo);
        LogInfo old = this.getLog(logInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.logMap.put(logInfo.getId(), copy);
        return new LogInfo(copy);
    }

    @Override
    public StatusInfo deleteLog(String logId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // DELETE
        if (this.logMap.remove(logId) == null) {
            throw new OperationFailedException(logId);
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
    public List<ValidationResultInfo> validateLogEntry(String validationTypeKey, String logEntryTypeKey, String logId,
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
    public LogEntryInfo createLogEntry(String logEntryTypeKey, String logId, LogEntryInfo logEntryInfo, ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        // CREATE
        if (!logEntryTypeKey.equals(logEntryInfo.getTypeKey())) {
            throw new InvalidParameterException("The type parameter does not match the type on the info object");
        }
        // TODO: check the rest of the readonly fields that are specified on the create to make sure they match the info object
        LogEntryInfo copy = new LogEntryInfo(logEntryInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        logEntryMap.put(copy.getId(), copy);
        return new LogEntryInfo(copy);
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
    public List<LogEntryInfo> getLogEntriesByLog(String logId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // GET_INFOS_BY_OTHER
        List<LogEntryInfo> list = new ArrayList<LogEntryInfo>();
        for (LogEntryInfo info : logEntryMap.values()) {
            if (logId.equals(info.getLogId())) {
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
        meta.setCreateTime(new Date());
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(meta.getCreateTime());
        meta.setVersionInd("0");
        return meta;
    }

    private MetaInfo updateMeta(MetaInfo old, ContextInfo context) {
        MetaInfo meta = new MetaInfo(old);
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(new Date());
        meta.setVersionInd((Integer.parseInt(meta.getVersionInd()) + 1) + "");
        return meta;
    }

}
