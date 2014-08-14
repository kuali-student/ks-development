package org.kuali.student.core.logging.service;

/**
 * This class holds the type state constants used by the Log service
 */
public class LoggingServiceTypeStateConstants extends LoggingServiceNamespace {
    
    public static final String PROCESS_LOG_TYPE = "kuali.log.type.process";
    public static final String ABORT_LOG_ENTRY_TYPE = "kuali.log.entry.type.process.abort";
    public static final String FAILURE_LOG_ENTRY_TYPE = "kuali.log.entry.type.transaction.failure";
    public static final String SUMMARY_RESULTS_LOG_ENTRY_TYPE = "kuali.log.entry.type.summary.results";
    
    public static final String OPEN_LOG_STATE = "kuali.log.state.open";
    public static final String CLOSED_LOG_STATE = "kuali.log.state.closed";
    
    public static final String WRITTEN_LOG_ENRY_STATE = "kuali.log.entry.state.written";
    
}
