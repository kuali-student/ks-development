package org.kuali.student.enrollment.courseoffering.service;


import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationSubscriptionService;
import org.kuali.student.r2.common.constants.CommonServiceConstants;

public class CourseOfferingSubscriptionNamespaceConstants {

    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "courseOfferingSubscriptionService";
    public static final String SERVICE_NAME_LOCAL_PART = CourseRegistrationSubscriptionService.class.getSimpleName();

}
