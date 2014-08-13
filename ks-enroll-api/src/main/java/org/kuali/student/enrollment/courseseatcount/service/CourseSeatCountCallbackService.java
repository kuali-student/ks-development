package org.kuali.student.enrollment.courseseatcount.service;


import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(name = "CourseSeatCountCallbackService", targetNamespace = CourseSeatCountCallbackNamespaceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CourseSeatCountCallbackService {

    /**
     * Callback for when CourseSeatCounts are created.
     *
     *
     * @param courseSeatCountIds ids created.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo newCourseSeatCounts(@WebParam(name = "courseSeatCountIds") List<String> courseSeatCountIds,
                                         @WebParam(name = "contextInfo")ContextInfo contextInfo);

    /**
     * Callback for when CourseSeatCounts are updated.
     *
     *
     * @param courseSeatCountIds ids updated.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo updateCourseOfferings(@WebParam(name = "courseSeatCountIds") List<String> courseSeatCountIds,
                                            @WebParam(name = "contextInfo")ContextInfo contextInfo);

    /**
     * Callback for when CourseSeatCounts are deleted.
     *
     *
     * @param courseSeatCountIds ids deleted.
     * @param contextInfo information containing the principalId and
     *                              locale information about the caller of
     *                              service operation
     * @return nothing
     */
    public StatusInfo deleteCourseOfferings(@WebParam(name = "courseSeatCountIds") List<String> courseSeatCountIds,
                                            @WebParam(name = "contextInfo")ContextInfo contextInfo );

}
