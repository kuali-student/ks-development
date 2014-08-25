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

import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.core.logging.dto.LogInfo;

/**
 * Utility to make it easy to log
 */
public class ProcessLogger {

    private LoggingService loggingService;
    private String logKey;
    private LogInfo log;
    private ContextInfo contextInfo;

    public ProcessLogger() {
    }

    public ProcessLogger(String logKey, LoggingService loggingService, ContextInfo contextInfo) {
        this.logKey = logKey;
        this.loggingService = loggingService;
        this.contextInfo = contextInfo;
        try {
            log = loggingService.findCreateLog(logKey,
                    LoggingServiceTypeStateConstants.PROCESS_LOG_TYPE, contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    } 
    
    private void logLoggingException(Exception ex) {
        System.err.println("Got an exception when invoking the logging service");
    }

    public String getLogKey() {
        return logKey;
    }

    public void setLogKey(String logKey) {
        this.logKey = logKey;
    }

    public ContextInfo getContextInfo() {
        return contextInfo;
    }

    public void setContextInfo(ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
    }

    public LogInfo getLog() {
        return log;
    }
    
    
    public LoggingService getLoggingService() {
        return loggingService;
    }

    public void setLoggingService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    /**
     * Convenience method to log a message indicating that the process was started
     *
     * The log level is INFO.
     *
     */
    public void started() {
        this.started(null);
    }

    /**
     * Convenience method to log a message indicating that the process was started
     *
     * The log level is INFO.
     *
     * @param details optional details to be logged
     */
    public void started(String details) {
        StringBuilder sb = new StringBuilder();
        sb.append("Process ");
        sb.append(this.log.getName());
        sb.append(" started");
        if (details != null) {
            sb.append(" ");
            sb.append(details);
        }
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.STARTED_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                    sb.toString(), contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating the progress of the process
     *
     * The log level is DEBUG.
     *
     * @param msg to be logged
     */
    public void progress(String msg) {
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.PROGRESS_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE,
                    msg, contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    private Long totalRecordsToProcess = null;

    public Long getTotalRecordsToProcess() {
        return totalRecordsToProcess;
    }

    /**
     * By setting this your progress messages are written with this total appended.
     */
    public void setTotalRecordsToProcess(Long totalRecordsToProcess) {
        this.totalRecordsToProcess = totalRecordsToProcess;
    }

    private Long progressIncrement = null;

    public Long getProgressIncrement() {
        return progressIncrement;
    }

    /**
     * If set then the level is set to INFO every time the increment is hit
     *
     * @param progressIncrement
     */
    public void setProgressIncrement(Long progressIncrement) {
        this.progressIncrement = progressIncrement;
    }

    /**
     * Convenience method to log a message indicating the progress of the process
     *
     * The log level is DEBUG unless the progreessIncrement is hit then the level is INOFO.
     *
     * @param recordsProcessed
     */
    public void progress(long recordsProcessed) {
        StringBuilder sb = new StringBuilder();
        sb.append(recordsProcessed);
        sb.append(" records processed");
        if (this.totalRecordsToProcess != null) {
            sb.append(" out of ");
            sb.append(this.totalRecordsToProcess);
        }
        String levelType = LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE;
        if (progressIncrement != null) {
            if (recordsProcessed % this.progressIncrement == 0) {
                levelType = LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE;
            }
        }
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.PROGRESS_LOG_ENTRY_TYPE,
                    levelType,
                    sb.toString(), contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating a particular item was processed successfully
     *
     * This is logged at the DEBUG level which is normally turned off.
     *
     * @param msg to be logged
     */
    private void processedInternal(String msg) {
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.PROCESSED_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE,
                    msg, contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating the successful processing of a particular transaction
     *
     * The log level is DEBUG.
     *
     * @param identifier indicating which item failed
     */
    public void processed(String identifier) {
        this.processed(identifier, (String) null);
    }

    /**
     * Convenience method to log a message indicating the successful processing of a particular transaction
     *
     * The log level is DEBUG.
     *
     * @param identifier indicating which item failed
     * @param details optional details to be displayed
     */
    public void processed(String identifier, String details) {
        StringBuilder sb = new StringBuilder();
        sb.append(identifier);
        sb.append(" successfully processed. ");
        if (details != null) {
            sb.append(" ");
            sb.append(details);
        }
        this.processedInternal(sb.toString());
    }

    /**
     * Convenience method to log a message indicating the failure of a particular transaction
     *
     * The log level is ERROR.
     *
     * @param msg to be logged
     */
    private void failureInternal(String msg) {
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.FAILURE_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.ERROR_LEVEL_TYPE,
                    msg, contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating the failure of a particular transaction
     *
     * The log level is ERROR.
     *
     * @param identifier indicating which item failed
     * @param reason reason for failure to be logged
     */
    public void failure(String identifier, String reason) {
        StringBuilder sb = new StringBuilder();
        sb.append(identifier);
        sb.append(" failed");
        sb.append(" because ");
        sb.append(reason);
        this.failureInternal(sb.toString());
    }

    /**
     * Convenience method to log a message indicating the failure of a particular transaction with the specified throwable
     *
     * The log level is ERROR.
     *
     * @param identifier indicating which item failed
     * @param throwable to be logged
     */
    public void failure(String identifier, Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(identifier);
        sb.append(" failed with the following error: ");
        sb.append(serialize(throwable));
        this.failureInternal(sb.toString());
    }

    /**
     * Convenience method to log a message indicating that the process aborted
     *
     * The log level is FATAL.
     *
     * @param details to be logged
     */
    public void abort(String details) {
        StringBuilder sb = new StringBuilder();
        sb.append("Process ");
        sb.append(this.log.getName());
        sb.append(" aborted.");
        if (details != null) {
            sb.append(" ");
            sb.append(details);
        }
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.ABORT_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.FATAL_LEVEL_TYPE,
                    sb.toString(), contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating that the process aborted with the specified exception.
     *
     * The log level is FATAL.
     *
     * @param msg to be logged
     * @param throwable throwable to be logged
     */
    public void abort(String msg, Throwable throwable) {
        if (throwable != null) {
            msg = msg + serialize(throwable);
        }
        this.abort(msg);
    }

    /**
     * Convenience method to log a message indicating that the process aborted with the specified exception.
     *
     * The log level is FATAL.
     *
     * @param throwable throwable to be logged
     */
    public void abort(Throwable throwable) {
        this.abort(serialize(throwable));
    }

    public static String serialize(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionUtils.getMessage(throwable));
        sb.append("\n");
        sb.append(ExceptionUtils.getFullStackTrace(throwable));
        return sb.toString();
    }

    public static String serialize(Map<?, ?> results) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : results.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Convenience method to log a message containing results of the process
     *
     * The log level is INFO.
     *
     * @param results map to be written
     */
    public void results(Map<String, ? extends Number> results) {
        String msg = serialize(results);
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.RESULTS_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                    msg, contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convenience method to log a message indicating that the process successfully completed
     *
     * The log level is INFO.
     *
     */
    public void success() {
        this.success(null);
    }

    /**
     * Convenience method to log a message indicating that the process successfully completed
     *
     * The log level is INFO.
     *
     * @param details optional details to be logged
     */
    public void success(String details) {
        StringBuilder sb = new StringBuilder();
        sb.append("Process ");
        sb.append(this.log.getName());
        sb.append(" successfully completed.");
        if (details != null) {
            sb.append(" ");
            sb.append(details);
        }
        try {
            loggingService.logEntry(log.getKey(),
                    LoggingServiceTypeStateConstants.SUCCESS_LOG_ENTRY_TYPE,
                    LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                    sb.toString(), contextInfo);
        } catch (Exception ex) {
            this.logLoggingException(ex);
            throw new RuntimeException(ex);
        }
    }

}
