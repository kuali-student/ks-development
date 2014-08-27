package org.kuali.student.enrollment.courseregistration.service;


import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(name = "CourseRegistrationCallbackService", targetNamespace = CourseRegistrationCallbackNamespaceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseRegistrationCallbackService {
    /**
     * Callback for when CourseRegistration are created.
     *
     *
     * @param courseRegistrationIds ids created.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo createCourseRegistrations(@WebParam(name = "courseRegistration") List<String> courseRegistrationIds,
                                          @WebParam(name = "contextInfo")ContextInfo contextInfo);

    /**
     * Callback for when CourseSeatCounts are updated.
     *
     *
     * @param courseRegistrationIds ids updated.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo updateCourseRegistration(@WebParam(name = "courseRegistrationIds") List<String> courseRegistrationIds,
                                            @WebParam(name = "contextInfo")ContextInfo contextInfo);

    /**
     * Callback for when CourseSeatCounts are deleted.
     *
     *
     * @param courseRegistrationIds ids deleted.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo deleteCourseRegistration(@WebParam(name = "courseRegistrationIds") List<String> courseRegistrationIds,
                                            @WebParam(name = "contextInfo")ContextInfo contextInfo );

}
