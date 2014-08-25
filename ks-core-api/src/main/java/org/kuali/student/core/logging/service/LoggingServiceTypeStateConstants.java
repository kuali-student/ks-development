package org.kuali.student.core.logging.service;

/**
 * This class holds the type state constants used by the Log service
 */
public class LoggingServiceTypeStateConstants extends LoggingServiceNamespace {
    
    /**
     * log types
     */
    public static final String PROCESS_LOG_TYPE = "kuali.logging.log.type.process";
    public static final String ACCESS_LOG_TYPE = "kuali.logging.log.type.access";
    /**
     * log entry types
     */
    public static final String STARTED_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.started";
    public static final String PROCESSED_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.processed";
    public static final String FAILURE_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.failure";
    public static final String PROGRESS_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.progress";
    public static final String ABORT_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.abort";
    public static final String RESULTS_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.results";
    public static final String SUCCESS_LOG_ENTRY_TYPE = "kuali.logging.log.entry.type.success";
    
    /**
     * log states
     */
    public static final String LOG_LIFECYCLE = "kuali.logging.log.lifecycle";  
    public static final String OPEN_LOG_STATE = "kuali.logging.log.state.open";
    public static final String CLOSED_LOG_STATE = "kuali.logging.log.state.closed";
    
    /**
     * log entry states
     */
    public static final String LOG_ENTRY_LIFECYCLE = "kuali.logging.log.entry.lifecycle";    
    public static final String WRITTEN_LOG_ENRY_STATE = "kuali.logging.log.entry.state.written";
    
    /**
     * Log entry level types
     */
    public static final String INFO_LEVEL_TYPE = "kuali.logging.log.entry.level.type.info";
    public static final String WARN_LEVEL_TYPE = "kuali.logging.log.entry.level.type.warn";
    public static final String ERROR_LEVEL_TYPE = "kuali.logging.log.entry.level.type.error";
    public static final String DEBUG_LEVEL_TYPE = "kuali.logging.log.entry.level.type.debug";
    public static final String TRACE_LEVEL_TYPE = "kuali.logging.log.entry.level.type.trace";
    public static final String FATAL_LEVEL_TYPE = "kuali.logging.log.entry.level.type.fatal";
    
    
}
