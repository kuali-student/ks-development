/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kuali.student.core.logging.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.core.logging.dto.LogInfo;
import org.kuali.student.r2.common.dto.ContextInfo;

/**
 *
 * @author nwright
 */
public class LoggingServiceLog4jImplTest {

    public LoggingServiceLog4jImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    LoggingService service;

    @Before
    public void setUp() {

        service = new LoggingServiceLog4jImpl();
        File file = new File("target/ks-common-api-tests.log");
        if (file.exists()) {
            System.out.println("deleting the log file ");
            file.delete();
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLog method, of class LoggingServiceLog4jImpl.
     */
    @Test
    public void testCrud() throws Exception {
        System.out.println("crud");

        ContextInfo context = new ContextInfo();
        context.setPrincipalId("UNIT-TEST-USER");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");
        context.setCurrentDate(df.parse("2014-08-22 12:01:22,393"));

        
        QueryByCriteria.Builder criteria = QueryByCriteria.Builder.create();
        List<LogInfo> list = this.service.searchForLogs(criteria.build(), context);
//        for (LogInfo info : list) {
//            System.out.println ("log=" + info);
//        }
        assertEquals (0, list.size());
        
        String logKey = "MyBatchProcessLogTestingCRUDMethods";

        LogInfo log = service.findCreateLog(logKey,
                LoggingServiceTypeStateConstants.PROCESS_LOG_TYPE, context);
        assertEquals(logKey, log.getKey());
        assertEquals(logKey, log.getName());
        
        
        criteria = QueryByCriteria.Builder.create();
        list = this.service.searchForLogs(criteria.build(), context);
//        for (LogInfo info : list) {
//            System.out.println ("log=" + info);
//        }
        assertEquals (1, list.size()); 

        LogEntryInfo original = new LogEntryInfo();
        original.setLogKey(logKey);
        original.setTypeKey(LoggingServiceTypeStateConstants.FAILURE_LOG_ENTRY_TYPE);
        original.setLevelTypeKey(LoggingServiceTypeStateConstants.ERROR_LEVEL_TYPE);
        original.setPrincipalId("A-DIFFERENT-USER");
        original.setTimeStamp(df.parse("2012-09-22 10:12:15,393"));
        original.setStateKey(LoggingServiceTypeStateConstants.WRITTEN_LOG_ENRY_STATE);
        original.setEntry("Item 75 has failed");
        LogEntryInfo actual = service.createLogEntry(original.getLogKey(), original.getTypeKey(), original, context);
        assertNotNull(actual.getId());
        assertNotNull(actual.getMeta());
        assertEquals(context.getPrincipalId(), actual.getMeta().getCreateId());
        assertEquals(context.getCurrentDate(), actual.getMeta().getCreateTime());
        assertEquals(original.getLogKey(), actual.getLogKey());
        assertEquals(original.getTypeKey(), actual.getTypeKey());
        assertEquals(original.getStateKey(), actual.getStateKey());
        assertEquals(original.getLevelTypeKey(), actual.getLevelTypeKey());
        assertEquals(original.getPrincipalId(), actual.getPrincipalId());
        assertEquals(original.getTimeStamp(), actual.getTimeStamp());
        assertEquals(original.getEntry(), actual.getEntry());

        original = actual;

        actual = this.service.getLogEntry(original.getId(), context);
        assertEquals(original.getId(), actual.getId());
        assertEquals(original.getMeta().getCreateId(), actual.getMeta().getCreateId());
        assertEquals(original.getMeta().getCreateTime(), actual.getMeta().getCreateTime());
        assertEquals(original.getLogKey(), actual.getLogKey());
        assertEquals(original.getTypeKey(), actual.getTypeKey());
        assertEquals(original.getStateKey(), actual.getStateKey());
        assertEquals(original.getLevelTypeKey(), actual.getLevelTypeKey());
        assertEquals(original.getPrincipalId(), actual.getPrincipalId());
        assertEquals(original.getTimeStamp(), actual.getTimeStamp());
        assertEquals(original.getEntry(), actual.getEntry());

        original = actual;

        original.setEntry(original.getEntry() + " \t updated with embedded tabs \t multiple");
        actual = this.service.updateLogEntry(original.getId(), original, context);
        assertEquals(original.getId(), actual.getId());
        assertEquals(original.getMeta().getCreateId(), actual.getMeta().getCreateId());
        assertEquals(original.getMeta().getCreateTime(), actual.getMeta().getCreateTime());
        assertEquals(original.getLogKey(), actual.getLogKey());
        assertEquals(original.getTypeKey(), actual.getTypeKey());
        assertEquals(original.getStateKey(), actual.getStateKey());
        assertEquals(original.getLevelTypeKey(), actual.getLevelTypeKey());
        assertEquals(original.getPrincipalId(), actual.getPrincipalId());
        assertEquals(original.getTimeStamp(), actual.getTimeStamp());
        assertEquals(original.getEntry(), actual.getEntry());

        original = actual;

        actual = this.service.getLogEntry(original.getId(), context);
        assertEquals(original.getId(), actual.getId());
        assertEquals(original.getMeta().getCreateId(), actual.getMeta().getCreateId());
        assertEquals(original.getMeta().getCreateTime(), actual.getMeta().getCreateTime());
        assertEquals(original.getLogKey(), actual.getLogKey());
        assertEquals(original.getTypeKey(), actual.getTypeKey());
        assertEquals(original.getStateKey(), actual.getStateKey());
        assertEquals(original.getLevelTypeKey(), actual.getLevelTypeKey());
        assertEquals(original.getPrincipalId(), actual.getPrincipalId());
        assertEquals(original.getTimeStamp(), actual.getTimeStamp());
        assertEquals(original.getEntry(), actual.getEntry());
    }

    @Test
    public void testLoggingConvenienceMethods() throws Exception {
        System.out.println("logging");

        ContextInfo context = new ContextInfo();
        context.setPrincipalId("UNIT-TEST-USER");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");
        context.setCurrentDate(df.parse("2014-08-22 12:01:22,393"));

        String logKey = "MyBatchProcessLogTestingConvenienceMethods";

        LogInfo log = service.findCreateLog(logKey,
                LoggingServiceTypeStateConstants.PROCESS_LOG_TYPE, context);
        assertEquals(logKey, log.getKey());
        assertEquals(logKey, log.getName());

        service.logEntry(log.getKey(),
                LoggingServiceTypeStateConstants.STARTED_LOG_ENTRY_TYPE,
                LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                "The process has started", context);

        List<LogEntryInfo> entries = service.getLogEntriesByLog(log.getKey(), context);
        assertEquals(1, entries.size());
        LogEntryInfo info = entries.get(0);
        assertEquals(logKey, info.getLogKey());
        assertNotNull(info.getId());
        assertEquals(LoggingServiceTypeStateConstants.STARTED_LOG_ENTRY_TYPE, info.getTypeKey());
        assertEquals(LoggingServiceTypeStateConstants.WRITTEN_LOG_ENRY_STATE, info.getStateKey());
        assertEquals(context.getCurrentDate(), info.getTimeStamp());
        assertEquals(context.getPrincipalId(), info.getPrincipalId());
        assertEquals(LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE, info.getLevelTypeKey());
        assertEquals("The process has started", info.getEntry());
        assertEquals("0", info.getMeta().getVersionInd());
        assertEquals(context.getPrincipalId(), info.getMeta().getCreateId());

        service.logEntry(log.getKey(),
                LoggingServiceTypeStateConstants.RESULTS_LOG_ENTRY_TYPE,
                LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                "100 processed out of 1000 records to be processed", context);
        service.logEntry(log.getKey(),
                LoggingServiceTypeStateConstants.RESULTS_LOG_ENTRY_TYPE,
                LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                "200 processed out of 1000 records to be processed", context);
        service.logEntry(log.getKey(),
                LoggingServiceTypeStateConstants.FAILURE_LOG_ENTRY_TYPE,
                LoggingServiceTypeStateConstants.ERROR_LEVEL_TYPE,
                "Item 259 could not be processed", context);
        service.logEntry(log.getKey(),
                LoggingServiceTypeStateConstants.SUCCESS_LOG_ENTRY_TYPE,
                LoggingServiceTypeStateConstants.INFO_LEVEL_TYPE,
                "The process has successfully completed processing \t test embedded tabs \t again", context);

        // for debugging show the file
        File file = new File("target/ks-common-api-tests.log");
        System.out.println("dumping out log file.....");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            i++;
            System.out.println("Line " + i + ": " + line);
        }
        br.close();
        
        entries = service.getLogEntriesByLog(log.getKey(), context);
        assertEquals(5, entries.size());

    }

}
