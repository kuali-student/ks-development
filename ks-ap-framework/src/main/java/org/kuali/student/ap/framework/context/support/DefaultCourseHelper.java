package org.kuali.student.ap.framework.context.support;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.config.property.ConfigContext;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.ap.academicplan.constants.AcademicPlanServiceConstants;
import org.kuali.student.ap.academicplan.infc.PlanItem;
import org.kuali.student.ap.coursesearch.CourseSearchItem;
import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.CourseHelper;
import org.kuali.student.ap.framework.context.CourseSearchConstants;
import org.kuali.student.ap.framework.util.KsapHelperUtil;
import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingDisplayInfo;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.FormatOfferingInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.r2.common.dto.AttributeInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.kuali.student.r2.core.acal.infc.Term;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultRowInfo;
import org.kuali.student.r2.core.versionmanagement.dto.VersionDisplayInfo;
import org.kuali.student.r2.lum.course.dto.CourseInfo;
import org.kuali.student.r2.lum.course.infc.Course;
import org.kuali.student.r2.lum.course.service.CourseService;
import org.kuali.student.r2.lum.util.constants.CluServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.kuali.rice.core.api.criteria.PredicateFactory.equal;
import static org.kuali.rice.core.api.criteria.PredicateFactory.or;

//
public class DefaultCourseHelper implements CourseHelper, Serializable {

	private static final long serialVersionUID = 8000868050066661992L;

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCourseHelper.class);

	@Override
	public void frontLoad(List<String> courseIds, String... termId) {

	}

    @Override
	public CourseInfo getCourseInfo(String courseId) {
		// call through service locator to facilitate proxying delegate override of getCurrentVersionIdOfCourse
		String verifiedCourseId = KsapFrameworkServiceLocator.getCourseHelper().getCurrentVersionIdOfCourse(courseId);
		CourseInfo rv;
        try {
            rv = KsapFrameworkServiceLocator.getCourseService().getCourse(verifiedCourseId,
                    KsapFrameworkServiceLocator.getContext().getContextInfo());
        } catch (DoesNotExistException e) {
            return null;
        } catch (MissingParameterException | InvalidParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("CLU lookup error", e);
        }
		return rv;
	}

	@Override
	public List<ActivityOfferingDisplayInfo> getActivityOfferingDisplaysByCourseAndTerm(String courseId, String termId) {
		List<ActivityOfferingDisplayInfo> rv;
        try {
            CourseOfferingService courseOfferingService = KsapFrameworkServiceLocator.getCourseOfferingService();
            ContextInfo context = KsapFrameworkServiceLocator.getContext().getContextInfo();
            rv = new java.util.LinkedList<ActivityOfferingDisplayInfo>();
            StringBuilder msg = null;
            if (LOG.isDebugEnabled())
                msg = new StringBuilder("CO cache miss ").append(courseId).append(" ").append(termId);
            for (CourseOfferingInfo co : courseOfferingService.getCourseOfferingsByCourseAndTerm(courseId, termId,
                    context)) {
                if (LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY.equalsIgnoreCase(co.getStateKey())) {
                    if (msg != null)
                        msg.append("\n  CO ").append(co.getId());
                    List<ActivityOfferingDisplayInfo> aol = KsapFrameworkServiceLocator.getCourseOfferingService()
                            .getActivityOfferingDisplaysForCourseOffering(co.getId(),
                                    KsapFrameworkServiceLocator.getContext().getContextInfo());
                    for (ActivityOfferingDisplayInfo aodi : aol) {
                        if (msg != null)
                            msg.append("\n    AO ").append(aodi.getId());
                        rv.add(aodi);
                    }
                }
            }
            if (msg != null)
                LOG.debug(msg.toString());
        } catch (DoesNotExistException | InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("CO lookup failure", e);
        }
		return rv;
	}

	@Override
	public List<String> getScheduledTermsForCourse(Course course) {
		ContextInfo ctx = KsapFrameworkServiceLocator.getContext().getContextInfo();
        List<String> scheduledTerms = new java.util.LinkedList<String>();
		try {
            List<CourseOfferingInfo> offerings = KsapFrameworkServiceLocator.getCourseOfferingService().getCourseOfferingsByCourse(course.getId(),ctx);

            List<Term> terms = new ArrayList<Term>();
            List<Term> currentScheduled = KsapFrameworkServiceLocator.getTermHelper().getCurrentTermsWithPublishedSOC();
            List<Term> futureScheduled = KsapFrameworkServiceLocator.getTermHelper().getFutureTermsWithPublishedSOC();
            if(currentScheduled!=null) terms.addAll(currentScheduled);
            if(futureScheduled!=null) terms.addAll(futureScheduled);

            for(CourseOfferingInfo offering : offerings){
                if (LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY.equalsIgnoreCase(offering.getStateKey())) {
                    for(Term t : terms) {
                        if(offering.getTermId().equals(t.getId())){
                            if(!scheduledTerms.contains(t.getId())){
                                scheduledTerms.add(t.getId());
                            }
                        }
                    }
                }
            }
			return scheduledTerms;
		} catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException | DoesNotExistException e) {
			throw new IllegalArgumentException("CO lookup failure", e);
        }
	}

    @Override
    public List<CourseOfferingInfo> getCourseOfferingsForCourses(List<CourseSearchItem> courses){
        List<CourseOfferingInfo> offerings = new ArrayList<CourseOfferingInfo>();
        try {
            // Load list of terms to find offerings in
            List<Term> terms = new ArrayList<Term>();
            List<Term> currentScheduled = KsapFrameworkServiceLocator.getTermHelper().getCurrentTermsWithPublishedSOC();
            List<Term> futureScheduled = KsapFrameworkServiceLocator.getTermHelper().getFutureTermsWithPublishedSOC();
            if(currentScheduled!=null) terms.addAll(currentScheduled);
            if(futureScheduled!=null) terms.addAll(futureScheduled);
            // Search for all course offerings of search results in terms
            Predicate termPredicates[] = KsapHelperUtil.getTermPredicates(terms);
            List<CourseSearchItem> tempCourses = new ArrayList<CourseSearchItem>(courses);
            Predicate coursePredicates[] = KsapHelperUtil.getCoursePredicates(tempCourses);
            QueryByCriteria query = QueryByCriteria.Builder.fromPredicates(or(coursePredicates),
                    or(termPredicates), equal("luiType", LuiServiceConstants.COURSE_OFFERING_TYPE_KEY),
                    equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY));
            offerings = KsapFrameworkServiceLocator.getCourseOfferingService()
                    .searchForCourseOfferings(query,KsapFrameworkServiceLocator.getContext().getContextInfo());
        } catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("ATP lookup failed", e);
         }

        return offerings;
    }

    @Override
    public List<CourseOfferingInfo> getCourseOfferingsForCoursesAndTerms(List<String> courseIds, List<Term> terms){
        List<CourseOfferingInfo> offerings = new ArrayList<CourseOfferingInfo>();
        try {
            // Load list of terms to find offerings in
            // Search for all course offerings of search results in terms
            Predicate termPredicates[] = KsapHelperUtil.getTermPredicates(terms);
            List<String> tempCourseIds = new ArrayList<String>(courseIds);
            Predicate coursePredicates[] = KsapHelperUtil.getCourseIdPredicates(tempCourseIds);
            QueryByCriteria query = QueryByCriteria.Builder.fromPredicates(or(coursePredicates),
                    or(termPredicates), equal("luiType", LuiServiceConstants.COURSE_OFFERING_TYPE_KEY),
                    equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY));
            offerings = KsapFrameworkServiceLocator.getCourseOfferingService()
                    .searchForCourseOfferings(query,KsapFrameworkServiceLocator.getContext().getContextInfo());
        } catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("ATP lookup failed", e);
        }

        return offerings;
    }



    /*
     *  - Only display Last Offered if it has been offered within the last 10 years.
     *  - If the course has not been offered within the last 10 years, return null
     */
	@Override
	public Term getLastOfferedTermForCourse(Course course) {
		ContextInfo ctx = KsapFrameworkServiceLocator.getContext().getContextInfo();
        Date currentDate = KsapHelperUtil.getCurrentDate();
        Term lastOfferedTerm = null;
        Term termInfo;

		try {
            List<CourseOfferingInfo> offerings = KsapFrameworkServiceLocator.getCourseOfferingService().getCourseOfferingsByCourse(course.getId(),ctx);
            for (CourseOfferingInfo co: offerings){                
                //check if the CO state is offered
                if (co.getStateKey().equalsIgnoreCase(LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY)){            
                    termInfo = KsapFrameworkServiceLocator.getAcademicCalendarService().getTerm(co.getTermId(), ctx);
                    //check if the term is NOT a future or a current term and within the last 10 years
                    Calendar currentCal = Calendar.getInstance();
                    currentCal.setTime(currentDate);
                    Calendar oldCal = Calendar.getInstance();
                    oldCal.set(currentCal.get(Calendar.YEAR)-10, currentCal.get(Calendar.MONTH), currentCal.get(Calendar.DAY_OF_MONTH));
                    Date oldDate = oldCal.getTime();

                    if (termInfo.getEndDate().before(currentDate) && termInfo.getEndDate().after(oldDate) )   {
                        if (lastOfferedTerm == null){
                            lastOfferedTerm = termInfo;
                        }
                        else if(lastOfferedTerm.getStartDate().before(termInfo.getStartDate()) && lastOfferedTerm.getEndDate().after(termInfo.getEndDate())) {
                                lastOfferedTerm = termInfo;
                        }
                    }
                }
            }
		} catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException | DoesNotExistException e) {
			throw new IllegalArgumentException("CO lookup failure", e);
        }

        return lastOfferedTerm;

	}


	@Override
	public List<Course> getCoursesByCode(String courseCd) {
		try {
            String cleanedCourseCd = StringUtils.remove(courseCd," ").toUpperCase();

			return new ArrayList<Course>(KsapFrameworkServiceLocator.getCourseService()
					.searchForCourses(
							QueryByCriteria.Builder.fromPredicates(PredicateFactory.equal("officialIdentifier.code",
                                    cleanedCourseCd)), KsapFrameworkServiceLocator.getContext().getContextInfo()));
		} catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
			throw new IllegalArgumentException("Course lookup error", e);
		}
	}

	@Override
	public String getCurrentVersionIdOfCourse(String courseId) {
		Course course = getCurrentVersionOfCourse(courseId);
        if (course != null)
            return course.getId();
        return null;
	}

    @Override
    public Course getCurrentVersionOfCourse(String courseId) {
        // Retrieve course information using the course code entered by the user
        Course course;
        try {
            ContextInfo contextInfo = KsapFrameworkServiceLocator.getContext().getContextInfo();
            course = KsapFrameworkServiceLocator.getCourseService().getCourse(courseId, contextInfo);
            VersionDisplayInfo currentVersion = KsapFrameworkServiceLocator.getCluService().getCurrentVersion(CluServiceConstants.CLU_NAMESPACE_URI, course.getVersion().getVersionIndId(), contextInfo);
            course = KsapFrameworkServiceLocator.getCourseService().getCourse(currentVersion.getId(), contextInfo);
        } catch (PermissionDeniedException | MissingParameterException | InvalidParameterException | OperationFailedException | DoesNotExistException e) {
            throw new IllegalArgumentException("Course service failure", e);
        }
        return course;
    }

    @Override
    public CourseInfo getCurrentVersionOfCourseByVersionIndependentId(String versionIndependentId) {
        // Retrieve course information using the course code entered by the user
        CourseInfo course;
        ContextInfo contextInfo = KsapFrameworkServiceLocator.getContext().getContextInfo();
        VersionDisplayInfo currentVersion = null;
        try {
            currentVersion = KsapFrameworkServiceLocator.getCluService().getCurrentVersion(CluServiceConstants.CLU_NAMESPACE_URI, versionIndependentId, contextInfo);
        } catch (DoesNotExistException e) {
            LOG.warn("No Current Version of Course Found, try to use the Latest Version.", e);
            try {
                currentVersion = KsapFrameworkServiceLocator.getCluService().getLatestVersion(CluServiceConstants.CLU_NAMESPACE_URI, versionIndependentId, contextInfo);
            } catch (DoesNotExistException | InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e1) {
                LOG.warn("No Latest Version of Course Found.");
                throw new IllegalArgumentException("Clu service failure", e1);
            }
        } catch (InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("Clu service failure", e);
         }

        try {
            course = KsapFrameworkServiceLocator.getCourseService().getCourse(currentVersion.getId(), contextInfo);
        } catch (PermissionDeniedException | MissingParameterException | InvalidParameterException | OperationFailedException | DoesNotExistException e) {
            throw new IllegalArgumentException("Course service failure", e);
         }
        return course;
    }

    @Override
    public List<String> getAllCourseIdsByVersionIndependentId(String versionIndependentId) {
        SearchRequestInfo request = new SearchRequestInfo(CourseSearchConstants.KSAP_COURSE_SEARCH_COURSEIDS_BY_VERSION_IND_ID_KEY);
        request.addParam(CourseSearchConstants.SearchParameters.VERSION_IND_ID, versionIndependentId);
        List<SearchResultRowInfo> rows = null;
        List<String> courseIds = new ArrayList<String>();
        try {
            rows = KsapFrameworkServiceLocator.getSearchService().search(request,
                    KsapFrameworkServiceLocator.getContext().getContextInfo()).getRows();
        } catch (MissingParameterException | InvalidParameterException | OperationFailedException | PermissionDeniedException e) {
            throw new IllegalArgumentException("Search service failure", e);
        }
        for(SearchResultRowInfo row : rows){
            courseIds.add(KsapHelperUtil.getCellValue(row, CourseSearchConstants.SearchResultColumns.CLU_ID));
        }
        return courseIds;
    }

    @Override
	public String getCourseCdFromActivityId(String activityId) {
		ActivityOfferingDisplayInfo activityDisplayInfo;
		try {
			activityDisplayInfo = KsapFrameworkServiceLocator.getCourseOfferingService().getActivityOfferingDisplay(
					activityId, KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (DoesNotExistException | MissingParameterException | InvalidParameterException | OperationFailedException | PermissionDeniedException e) {
			throw new IllegalArgumentException("CO lookup error", e);
		}
		assert activityDisplayInfo != null : "activity id " + activityId + " returned null";

		String courseOfferingId = null;
		for (AttributeInfo attributeInfo : activityDisplayInfo.getAttributes())
			if ("PrimaryActivityOfferingId".equalsIgnoreCase(attributeInfo.getKey()))
				courseOfferingId = attributeInfo.getValue();
		assert courseOfferingId != null : "activity id " + activityId + " missing PrimaryActiveOfferingId";

		try {
			CourseOfferingInfo courseOfferingInfo = KsapFrameworkServiceLocator.getCourseOfferingService()
					.getCourseOffering(courseOfferingId, KsapFrameworkServiceLocator.getContext().getContextInfo());
			if (courseOfferingInfo != null
                    && LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY.equalsIgnoreCase(courseOfferingInfo.getStateKey())) {
                return courseOfferingInfo.getCourseCode();
            } else {
                return null;
            }
		} catch (DoesNotExistException | MissingParameterException | InvalidParameterException | OperationFailedException | PermissionDeniedException e) {
			throw new IllegalArgumentException("CO lookup error", e);
		}
	}

    @Override
    public boolean isCourseOffered(Term term, Course course) {
        List<CourseOfferingInfo> cos = new ArrayList<CourseOfferingInfo>();
        try {
            List<CourseOfferingInfo> temp_cos = KsapFrameworkServiceLocator.getCourseOfferingService()
                    .getCourseOfferingsByCourseAndTerm(course.getId(), term.getId(),
                            KsapFrameworkServiceLocator.getContext().getContextInfo());
            for (CourseOfferingInfo co : temp_cos) {
                if (LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY.equalsIgnoreCase(co.getStateKey())){
                    cos.add(co);
                }
            }
            return cos != null && !cos.isEmpty();
        } catch (DoesNotExistException | InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
            return false;
        }
    }

    @Override
    public boolean isCourseBookmarked(Course course, List<PlanItem> planItems){
        for(PlanItem item : planItems){
            if(item.getCategory().equals(AcademicPlanServiceConstants.ItemCategory.WISHLIST)){
                return true;
            }
        }
        return false;
    }

    /**
     * @see org.kuali.student.ap.framework.context.CourseHelper#validateCourseForAdd(org.kuali.student.r2.lum.course.infc.Course)
     */
    @Override
    public String validateCourseForAdd(Course course) {

        if(course == null){
            return "No course found";
        }

        List<String> validStates = new ArrayList<String>();
        validStates.add("Active");
        validStates.add("Retired");
        validStates.add("Superseded");
        if(!validStates.contains(course.getStateKey())){
            return "Course " + course.getCode() + " is not an active course";
        }

        if(course.getExpirationDate()!=null && course.getExpirationDate().before(KsapHelperUtil.getCurrentDate())){
            return "Course " + course.getCode() + " is expired";
        }

        return null;
    }

    /**
     * Retrieve and format the list of projected terms to be displayed on the page
     *
     * @param course - Course that is being displayed
     * @return Formatted list of projected terms
     */
    @Override
    public List<String> getProjectedTermsForCourse(Course course){
        List<String> courseTermsOffered = course.getTermsOffered();
        Map<String, String> projectedTerms = new HashMap<String, String>();
        if (courseTermsOffered != null) {
            try {
                for (TypeInfo typeInfo : KsapFrameworkServiceLocator.getTypeService().getTypesByKeys(courseTermsOffered,
                        KsapFrameworkServiceLocator.getContext().getContextInfo()))
                    projectedTerms.put(typeInfo.getKey(), typeInfo.getName());
            } catch (DoesNotExistException | InvalidParameterException | MissingParameterException | OperationFailedException | PermissionDeniedException e) {
                throw new IllegalArgumentException("Type lookup error", e);
            }
        }
        return sortProjectedTerms(projectedTerms);
    }

    /**
     * Sort the terms offered (projected) based off of config values
     *
     * @param - Map containing information on terms to sort
     * @return A sorted List of Terms
     */
    protected List<String> sortProjectedTerms(Map<String, String> projectedTerms) {
        List<String> sortedTerms = new ArrayList<String>();
        String[] terms = ConfigContext.getCurrentContextConfig().getProperty(CourseSearchConstants.TERMS_OFFERED_SORTED_KEY).split(",");
        for (int i = 0; i < terms.length; i++) {
            String typeKey = terms[i];
            if (projectedTerms.containsKey(typeKey))
                sortedTerms.add(projectedTerms.get(typeKey));
        }
        return sortedTerms;
    }
}
