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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.common.UUIDHelper;
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

public class LoggingServiceLog4jImpl implements LoggingService {
    // cache variable 
    // The LinkedHashMap is just so the values come back in a predictable order

    @Override
    public LogInfo getLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        List<LogInfo> logs = getAllLogs();
        for (LogInfo log : logs) {
            if (log.getKey().equals(logKey)) {
                return log;
            }
        }
        throw new DoesNotExistException(logKey);
    }

    private List<LogInfo> getAllLogs() throws OperationFailedException {
        Enumeration<Logger> loggers = LogManager.getCurrentLoggers();
        List<LogInfo> list = new ArrayList<LogInfo>();
        while (loggers.hasMoreElements()) {
            Logger logger = loggers.nextElement();
            LogInfo info = this.logger2LogInfo(logger);
            list.add(info);
        }
        return list;
    }

    private LogInfo logger2LogInfo(Logger logger) throws OperationFailedException {
        LogInfo info = new LogInfo();
        info.setKey(logger.getName());
        info.setName(logger.getName());
        // need to figure out how to not hard code this and support multiple types 
        info.setTypeKey(LoggingServiceTypeStateConstants.PROCESS_LOG_TYPE);
        info.setStateKey(LoggingServiceTypeStateConstants.OPEN_LOG_STATE);
        info.setLevelTypeKey(this.level2Type(logger.getEffectiveLevel().toString()));
        return info;
    }

    @Override
    public List<LogInfo> getLogsByKeys(List<String> logKeys, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        List<LogInfo> list = new ArrayList<LogInfo>();
        List<LogInfo> logs = getAllLogs();
        for (LogInfo log : logs) {
            if (logKeys.contains(log.getKey())) {
                list.add(log);
            }
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
        List<String> list = new ArrayList<String>();
        List<LogInfo> logs = getAllLogs();
        for (LogInfo log : logs) {
            if (logTypeKey.equals(log.getTypeKey())) {
                list.add(log.getKey());
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
        List<String> list = new ArrayList<String>();
        for (LogInfo info : this.searchForLogs(criteria, contextInfo)) {
            list.add(info.getKey());
        }
        return list;
    }

    @Override
    public List<LogInfo> searchForLogs(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // Assume criteria is not specified so we get all 
        List<LogInfo> list = this.getAllLogs();
        return list;
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
        LogInfo existing = this.getLog(key, contextInfo);
        if (existing != null) {
            throw new AlreadyExistsException(key);
        }
        // this creates the log but only for the lifetime of the JVM
        Logger logger = Logger.getLogger(key);
        LogInfo info = this.logger2LogInfo(logger);
        return info;
    }

    @Override
    public LogInfo findCreateLog(String logKey, String logTypeKey, ContextInfo contextInfo) throws DataValidationErrorException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {
        try {
            LogInfo existing = this.getLog(logKey, contextInfo);
            return existing;
        } catch (DoesNotExistException ex) {
            // ok so create it
        }
        // this creates the log but only for the lifetime of the JVM
        Logger logger = Logger.getLogger(logKey);
        LogInfo info = this.logger2LogInfo(logger);
        return info;
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
        LogInfo log = this.getLog(logKey, contextInfo);
        Logger logger = Logger.getLogger(logKey);
        // the only thing we can really update is the level on both the logger and the file appender
        Level level = this.type2Level(logInfo.getLevelTypeKey());
        logger.setLevel(level);
        FileAppender fileAppender = this.getFileAppender(logger);
        fileAppender.setThreshold(level);
        System.out.println ("..............Set the level for logger " + logKey + " to " + level);
                
        return this.logger2LogInfo(logger);
    }

    @Override
    public StatusInfo deleteLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        throw new OperationFailedException("log4j logs cannot be deleted");
    }

    @Override
    public LogEntryInfo getLogEntry(String logEntryId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // if more than one found take the last one written with that ID 
        // that is how we are doing updates
        LogEntryInfo found = null;
        for (LogEntryInfo info : this.getAllLogEntries()) {
            if (info.getId().equals(logEntryId)) {
                found = info;
            }
        }
        if (found == null) {
            throw new DoesNotExistException(logEntryId);
        }
        return found;
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByIds(List<String> logEntryIds, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // if more than one found take the last one written with that ID 
        // that is how we are doing updates
        Map<String, LogEntryInfo> found = null;
        for (LogEntryInfo info : this.getAllLogEntries()) {
            if (logEntryIds.contains(info.getId())) {
                found.put(info.getId(), info);
            }
        }
        return new ArrayList<LogEntryInfo>(found.values());
    }

    @Override
    public List<String> getLogEntryIdsByType(String logEntryTypeKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        List<String> list = new ArrayList<String>();
        for (LogEntryInfo info : this.getAllLogEntries()) {
            if (info.getTypeKey().equals(logEntryTypeKey)) {
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
        this.writeLogEntry(copy);
        return copy;
    }

    private void writeLogEntry(LogEntryInfo info) throws OperationFailedException {
        Logger logger = Logger.getLogger(info.getLogKey());
        logger.log(type2Level(info.getLevelTypeKey()), format(info));
    }

    private List<LogEntryInfo> getAllLogEntries() throws OperationFailedException {
        // this assumes the file appender is attached to the root logger
        //log4j.rootLogger=INFO, console, file
        Logger logger = Logger.getRootLogger();
        FileAppender fileAppender = this.getFileAppender(logger);
        if (fileAppender == null) {
            throw new OperationFailedException("misconfiguration: log4j needs to be configured with a file appender");
        }
//        if (fileAppender.getBufferedIO()) {
//            if (!fileAppender.getImmediateFlush()) {
//                try {
//                    fileAppender.setImmediateFlush(true);
//                    logger.info("FLUSH");
//                } finally {
//                    fileAppender.setImmediateFlush(false);
//                }
//            }
//        }
        File file = new File(fileAppender.getFile());
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            throw new OperationFailedException("trouble opening file", ex);
        }
        List<LogEntryInfo> list = new ArrayList<LogEntryInfo>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
//                System.out.println("Line: " + line);
                LogEntryInfo info = this.parse(line);
                list.add(info);
            }
        } catch (IOException ex) {
            throw new OperationFailedException("trouble reading file", ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            throw new OperationFailedException("trouble closing file", ex);
        }
        return list;
    }

    private FileAppender getFileAppender(Category logger) {
        FileAppender fileAppender = null;
        Enumeration<Appender> enumeration = logger.getAllAppenders();
        while (enumeration.hasMoreElements()) {
            Appender appender = enumeration.nextElement();
            if (appender instanceof FileAppender) {
                fileAppender = (FileAppender) appender;
                return fileAppender;
            }
        }
        Category parent = logger.getParent();
        if (parent == null) {
            return null;
        }
        return this.getFileAppender(parent);
    }

//   this parsing assumes this pattern layout   
//   log4j.appender.file.layout=org.apache.log4j.PatternLayout
//   log4j.appender.file.layout.ConversionPattern=%d [%t] %-5p %c - %m%n
    private LogEntryInfo parse(String line) throws OperationFailedException {
        LogEntryInfo info = new LogEntryInfo();
        String[] tabParts = line.split("\t");
        String[] beginParts = tabParts[0].split(" ");
        MetaInfo meta = new MetaInfo();
//        meta.setCreateTime(this.toDate(beginParts[0] + " " + beginParts[1]));
        info.setMeta(meta);

        info.setId(tabParts[1]);
        // if level code is short there are trailing spaces after it so that causes the split
        // to create a bunch of empty strings that we have to get past to actually get to the logger name
        //  2014-08-23 13:52:47,114 [main] ERROR MyBatchProcessLogTestingCRUDMethods - 	
        // vs
        //  2014-08-23 13:52:47,114 [main] INFO  MyBatchProcessLogTestingCRUDMethods - 	
        info.setLogKey(beginParts[4]);
        if (info.getLogKey().isEmpty()) {
            info.setLogKey(beginParts[5]);
            if (info.getLogKey().isEmpty()) {
                info.setLogKey(beginParts[6]);
                if (info.getLogKey().isEmpty()) {
                    info.setLogKey(beginParts[7]);
                }
            }
        }
        info.setPrincipalId(tabParts[2]);
        info.setTimeStamp(toDate(tabParts[3]));
        info.setTypeKey(tabParts[4]);
        info.setStateKey(tabParts[5]);
        info.setLevelTypeKey(this.level2Type(beginParts[3]));
        info.getMeta().setCreateId(tabParts[6]);
        info.getMeta().setCreateTime(toDate(tabParts[7]));
        info.getMeta().setUpdateId(tabParts[8]);
        info.getMeta().setCreateTime(toDate(tabParts[9]));
        info.getMeta().setVersionInd(tabParts[10]);

        // rebuild the entry putting tabs back in where parsed out
        StringBuilder sb = new StringBuilder();
        String tab = "";
        for (int i = 11; i < tabParts.length; i++) {
            sb.append(tab);
            tab = "\t";
            sb.append(tabParts[i]);
        }
        if (sb.length() > 0) {
            String entry = deserialize (sb.toString());
            info.setEntry(entry);
        }
        return info;
    }

    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");

    private String formatDate(Date date) {
        if (date == null) {
            return "null";
        }
        return FORMATTER.format(date);
    }

    private Date toDate(String dateStr) throws OperationFailedException {
        if (dateStr == null) {
            return null;
        }
        if (dateStr.equals("")) {
            return null;
        }
        if (dateStr.equals("null")) {
            return null;
        }
        Date date;
        try {
            date = FORMATTER.parse(dateStr);
        } catch (ParseException ex) {
            throw new OperationFailedException("could not parse date string [" + dateStr + "]", ex);
        }
        return date;
    }

    private String format(LogEntryInfo info) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(info.getId());
        sb.append("\t");
        sb.append(info.getPrincipalId());
        sb.append("\t");
        sb.append(formatDate(info.getTimeStamp()));
        sb.append("\t");
        sb.append(info.getTypeKey());
        sb.append("\t");
        sb.append(info.getStateKey());
        sb.append("\t");
        sb.append(info.getMeta().getCreateId());
        sb.append("\t");
        sb.append(formatDate(info.getMeta().getCreateTime()));
        sb.append("\t");
        sb.append(info.getMeta().getUpdateId());
        sb.append("\t");
        sb.append(formatDate(info.getMeta().getUpdateTime()));
        sb.append("\t");
        sb.append(info.getMeta().getVersionInd());
        sb.append("\t");
        sb.append(serialize(info.getEntry()));
        return sb.toString();
    }

    // insert a UUID to be sure it does not appear in text
    public static final String LINE_FEED_TOKEN = "87e26cb5-25b0-4355-afb9-1012d78e8010";

    public static String serialize(String entry) {
        entry = entry.replaceAll("\r\n", LINE_FEED_TOKEN);
        entry = entry.replaceAll("\n", LINE_FEED_TOKEN);
        return entry;
    }

    public static String deserialize(String entry) {
        return entry.replaceAll(LINE_FEED_TOKEN, "\n");
    }

    /**
     * maps from KS level types to log4j levels
     */
    private Level type2Level(String typeKey) throws OperationFailedException {
        Level level = type2LevelMap.get(typeKey);
        if (level == null) {
            throw new OperationFailedException("unknown/unhandled level type " + typeKey);
        }
        return level;
    }
    private final Map<String, Level> type2LevelMap;

    {
        type2LevelMap = new LinkedHashMap<String, Level>();
        type2LevelMap.put(LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE, Level.DEBUG);
        type2LevelMap.put(LoggingServiceTypeStateConstants.TRACE_LEVEL_TYPE, Level.TRACE);
        type2LevelMap.put(LoggingServiceTypeStateConstants.ERROR_LEVEL_TYPE, Level.ERROR);
        type2LevelMap.put(LoggingServiceTypeStateConstants.WARN_LEVEL_TYPE, Level.WARN);
        type2LevelMap.put(LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE, Level.INFO);
        type2LevelMap.put(LoggingServiceTypeStateConstants.FATAL_LEVEL_TYPE, Level.FATAL);
    }

    private String level2Type(String level) throws OperationFailedException {
        String typeKey = level2TypeMap.get(level);
        if (typeKey == null) {
            throw new OperationFailedException("unknown/unhandled level " + level);
        }
        return typeKey;
    }
    private final Map<String, String> level2TypeMap;

    {
        level2TypeMap = new LinkedHashMap<String, String>();
        level2TypeMap.put(Level.DEBUG.toString(), LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE);
        level2TypeMap.put(Level.TRACE.toString(), LoggingServiceTypeStateConstants.TRACE_LEVEL_TYPE);
        level2TypeMap.put(Level.ERROR.toString(), LoggingServiceTypeStateConstants.ERROR_LEVEL_TYPE);
        level2TypeMap.put(Level.WARN.toString(), LoggingServiceTypeStateConstants.WARN_LEVEL_TYPE);
        level2TypeMap.put(Level.INFO.toString(), LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE);
        level2TypeMap.put(Level.FATAL.toString(), LoggingServiceTypeStateConstants.FATAL_LEVEL_TYPE);
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
        LogEntryInfo info = this.getLogEntry(logEntryId, contextInfo);
        LogEntryInfo copy = new LogEntryInfo(logEntryInfo);
        copy.setId(logEntryId);
        copy.setMeta(this.updateMeta(copy.getMeta(), contextInfo));
        this.writeLogEntry(copy);
        return copy;
    }

    @Override
    public StatusInfo deleteLogEntry(String logEntryId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        throw new OperationFailedException("log4j log entries cannot be deleted");
    }

    @Override
    public List<LogEntryInfo> getLogEntriesByLog(String logKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        List<LogEntryInfo> list = new ArrayList<LogEntryInfo>();
        for (LogEntryInfo info : this.getAllLogEntries()) {
            if (info.getLogKey().equals(logKey)) {
                list.add(info);
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
