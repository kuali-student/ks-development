/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kuali.student.core.logging.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kuali.student.core.logging.dto.LogEntryInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;

/**
 *
 * @author nwright
 */
public class ProcessLoggerTest {

    public ProcessLoggerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
//        File file = new File("target/ks-common-api-tests.log");
//        if (file.exists()) {
//            System.out.println("deleting the log file");
//            if (!file.delete()) {
//                throw new RuntimeException("failed to delete file");
//            }
//        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testProcessingLifecycle()
            throws FileNotFoundException,
            IOException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        System.out.println("processingLifeCycle");
        LoggingService service = new LoggingServiceLog4jImpl();

        ContextInfo context = new ContextInfo();
        context.setPrincipalId("UNIT-TEST-USER");

        ProcessLogger logger = new ProcessLogger("processingLifeCycle", service, context);
        this.processRecords(logger);

//        this.dumpFile();
        List<LogEntryInfo> entries = logger.getLoggingService().getLogEntriesByLog(logger.getLogKey(), logger.getContextInfo());
        assertEquals(216, entries.size());
        for (LogEntryInfo entry : entries) {
            System.out.println(entry.getEntry());
        }

    }

    private void processRecords(ProcessLogger logger) {
        int total = 1000;
        logger.started();
        Map<String, AtomicInteger> results = new LinkedHashMap<String, AtomicInteger>();
        results.put("total", new AtomicInteger(total));
        results.put("processed", new AtomicInteger());
        results.put("errors", new AtomicInteger());
        logger.setProgressIncrement(100l);
        logger.setTotalRecordsToProcess(new Long(total));
        Random random = new Random(111111l);
        for (int i = 0; i < total; i++) {
            String identifier = "row#" + i;
            int randomResult = random.nextInt(10);
            switch (randomResult) {
                case 0:
                    logger.failure(identifier, " random error");
                    results.get("errors").incrementAndGet();
                    break;
                case 1:
                    Throwable cause = new RuntimeException("random exception");
                    Throwable throwable = new RuntimeException("caused by exception", cause);
                    logger.failure(identifier, throwable);
                    results.get("errors").incrementAndGet();
                    break;
                default:
                    logger.processed(identifier);
                    results.get("processed").incrementAndGet();
                    break;
            }
            logger.progress(i);
        }
        logger.results(results);
        logger.success();

    }

    private void dumpFile() throws IOException {
//         // for debugging show the file
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
    }

    @Test
    public void testProcessingLifecycleSettingLevel()
            throws FileNotFoundException,
            IOException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            DataValidationErrorException,
            ReadOnlyException,
            VersionMismatchException {
        System.out.println("processingLifeCycleSettingLevel");
        LoggingService service = new LoggingServiceLog4jImpl();

        ContextInfo context = new ContextInfo();
        context.setPrincipalId("UNIT-TEST-USER");

        ProcessLogger logger = new ProcessLogger("processingLifeCycleSettingLevel", service, context);
        logger.getLog().setLevelTypeKey(LoggingServiceTypeStateConstants.DEBUG_LEVEL_TYPE);
        logger.getLoggingService().updateLog(logger.getLogKey(), logger.getLog(), logger.getContextInfo());

        this.processRecords(logger);

//        this.dumpFile();
        List<LogEntryInfo> entries = logger.getLoggingService().getLogEntriesByLog(logger.getLogKey(), logger.getContextInfo());
        assertEquals(2003, entries.size());
        for (LogEntryInfo entry : entries) {
            System.out.println(entry.getEntry());
        }

    }
}
