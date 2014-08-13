package org.kuali.student.enrollment.courseseatcount.service;


import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.enrollment.courseseatcount.dto.CourseSeatCountInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;


import java.util.List;

public class CourseSeatCountServiceDecorator implements CourseSeatCountService {

    private CourseSeatCountService nextDecorator;

    public CourseSeatCountService getNextDecorator() throws OperationFailedException{
        if (null == nextDecorator){
            throw new OperationFailedException("Misconfigured application: nextDecorator is null");
        }
        return nextDecorator;
    }

    public void setNextDecorator(CourseSeatCountService nextDecorator) {
        this.nextDecorator = nextDecorator;
    }

    @Override
    public CourseSeatCountInfo getCourseSeatCount(String courseSeatCountId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getCourseSeatCount(courseSeatCountId,contextInfo);
    }

    @Override
    public List<CourseSeatCountInfo> getCourseSeatCountsByIds(List<String> courseSeatCountIds, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getCourseSeatCountsByIds(courseSeatCountIds,contextInfo);
    }

    @Override
    public CourseSeatCountInfo getCourseSeatCountByActivityOffering(String activityOfferingId, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getCourseSeatCountByActivityOffering(activityOfferingId,contextInfo);
    }

    @Override
    public List<CourseSeatCountInfo> getSeatCountsByActivityOfferings(List<String> activityOfferingIds, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getSeatCountsByActivityOfferings(activityOfferingIds,contextInfo);
    }

    @Override
    public List<String> getCourseSeatCountIdsByType(String courseSeatCountTypeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getCourseSeatCountIdsByType(courseSeatCountTypeKey,contextInfo);
    }

    @Override
    public List<String> searchForCourseSeatCountIds(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForCourseSeatCountIds(criteria,contextInfo);
    }

    @Override
    public List<CourseSeatCountInfo> searchForCourseSeatCounts(QueryByCriteria criteria, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForCourseSeatCounts(criteria,contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateCourseSeatCount(String validationTypeKey, String courseSeatCountTypeKey, CourseSeatCountInfo courseSeatCountInfo, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().validateCourseSeatCount(validationTypeKey,courseSeatCountTypeKey,courseSeatCountInfo,contextInfo);
    }

    @Override
    public CourseSeatCountInfo createCourseSeatCount(String courseSeatCountTypeKey, CourseSeatCountInfo courseSeatCountInfo, ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return getNextDecorator().createCourseSeatCount(courseSeatCountTypeKey,courseSeatCountInfo,contextInfo);
    }

    @Override
    public CourseSeatCountInfo updateCourseSeatCount(String courseSeatCountId, CourseSeatCountInfo courseSeatCountInfo, ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return getNextDecorator().updateCourseSeatCount(courseSeatCountId,courseSeatCountInfo,contextInfo);
    }

    @Override
    public StatusInfo deleteCourseSeatCount(String courseSeatCountId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().deleteCourseSeatCount(courseSeatCountId,contextInfo);
    }
}
