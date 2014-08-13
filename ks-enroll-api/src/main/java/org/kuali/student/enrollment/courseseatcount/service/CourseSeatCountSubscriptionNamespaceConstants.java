package org.kuali.student.enrollment.courseseatcount.service;


import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationSubscriptionService;
import org.kuali.student.r2.common.constants.CommonServiceConstants;

public class CourseSeatCountSubscriptionNamespaceConstants {

    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "courseSeatCountSubscriptionService";
    public static final String SERVICE_NAME_LOCAL_PART = CourseRegistrationSubscriptionService.class.getSimpleName();

}
