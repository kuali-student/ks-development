package org.kuali.student.core.logging.service;

import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.core.logging.dto.LogInfo;
import org.kuali.student.r2.common.constants.CommonServiceConstants;

/**
 * This class holds the constants used by the Log service
 */
public class LoggingServiceNamespace {
    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "logging";
    public static final String REF_OBJECT_URI_LOG = NAMESPACE + "/" + LogInfo.class.getSimpleName();
    public static final String REF_OBJECT_URI_LOG_ENTRY = NAMESPACE + "/" + LogEntryInfo.class.getSimpleName();
    public static final String SERVICE_NAME_LOCAL_PART = "LoggingService";
    
    
}
