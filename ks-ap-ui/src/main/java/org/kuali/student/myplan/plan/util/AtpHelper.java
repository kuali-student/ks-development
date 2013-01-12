package org.kuali.student.myplan.plan.util;

import static org.kuali.rice.core.api.criteria.PredicateFactory.equalIgnoreCase;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.enrollment.acal.dto.TermInfo;
import org.kuali.student.enrollment.acal.service.AcademicCalendarService;
import org.kuali.student.myplan.plan.PlanConstants;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.atp.dto.AtpInfo;

/**
 * Helper methods for dealing with ATPs.
 */
public class AtpHelper {

	private static ContextInfo getContext() {
		return KsapFrameworkServiceLocator.getContext().getContextInfo();
	}

	/**
	 * Query the Academic Calendar Service, determine the current ATP, and the
	 * return the ID.
	 * 
	 * @return The ID of the current ATP.
	 */
	public static String getCurrentAtpId() {
		List<TermInfo> inProgressTerms;
		try {
			inProgressTerms = KsapFrameworkServiceLocator
					.getAcademicCalendarService()
					.searchForTerms(
							QueryByCriteria.Builder.fromPredicates(equalIgnoreCase(
									"query", PlanConstants.INPROGRESS)),
							getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in current ATP ID lookup", t);
		}
		assert inProgressTerms != null && inProgressTerms.size() > 1 : "No in-progress terms from acal service"
				+ inProgressTerms;
		return inProgressTerms.iterator().next().getId();
	}

	/**
	 * Query the Academic Calendar Service for terms that have offering's
	 * published, determine the last ATP, and return its ID.
	 * 
	 * @return The ID of the last scheduled ATP.
	 * @throws RuntimeException
	 *             if the query fails or if the return data set doesn't make
	 *             sense.
	 */
	public static String getLastScheduledAtpId() {
		List<TermInfo> scheduledTerms;
		try {
			scheduledTerms = KsapFrameworkServiceLocator
					.getAcademicCalendarService()
					.searchForTerms(
							QueryByCriteria.Builder.fromPredicates(equalIgnoreCase(
									"query", PlanConstants.PUBLISHED)),
							getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in current ATP ID lookup", t);
		}
		assert scheduledTerms != null && scheduledTerms.size() > 1 : "No scheduled terms from acal service"
				+ scheduledTerms;
		return scheduledTerms.get(scheduledTerms.size() - 1).getId();
	}

	/**
	 * Gets the ATP ID of the first ATP in the current academic year.
	 */

	public static String getFirstAtpIdOfAcademicYear(String atpId) {
		String[] termYear = atpIdToTermAndYear(atpId);
		String year = termYear[0];
		String term = termYear[1];

		// If the term is not Autumn/4 then the beginning of the academic year
		// is (year - 1) . 4
		if (term.equals("4")) {
			return atpId;
		} else {
			String y = String.valueOf(Integer.valueOf(year) - 1);
			return AtpHelper.getAtpFromNumTermAndYear("4", y);
		}
	}

	/**
	 * Returns an String[] {term, year} given an ATP ID.
	 */
	public static String[] atpIdToTermAndYear(String atpId) {
		AtpInfo atp;
		try {
			atp = KsapFrameworkServiceLocator.getAtpService().getAtp(atpId,
					getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in sheduled ATP ID lookup", t);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(atp.getStartDate());
		String year = new DecimalFormat("0000").format(c.get(Calendar.YEAR));
		String atptype = atp.getTypeKey();
		String term;
		if (atptype.equals("kuali.atp.type.Winter"))
			term = "1";
		else if (atptype.equals("kuali.atp.type.Spring"))
			term = "2";
		else if (atptype.equals("kuali.atp.type.Summer"))
			term = "3";
		else if (atptype.equals("kuali.atp.type.Fall"))
			term = "4";
		else
			throw new IllegalArgumentException(
					"Unable to determine term from ATP " + atp);
		return new String[] { term, year };
	}

	/**
	 * Converts an ATP ID to a Term and Year ... "kuali.uw.atp.1991.1" ->
	 * {"Autumn", "1991"}
	 * 
	 * @return A String array containing a term and year.
	 */
	public static String[] atpIdToTermNameAndYear(String atpId) {
		AtpInfo atp;
		try {
			atp = KsapFrameworkServiceLocator.getAtpService().getAtp(atpId,
					getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in ATP ID lookup", t);
		}
		assert atp != null : "Missing ATP for " + atpId;
		String descr = atp.getDescr().getPlain();
		String term = Pattern.compile("([A-Za-z]+)").matcher(descr).group(1);
		String year = Pattern.compile("([0-9]+)").matcher(descr).group(1);
		return new String[] { term, year };
	}

	public static String getAtpIdFromTermAndYear(String term, String year) {
		String ts = term == null ? "" : term.toUpperCase();
		final String termNum;
		if (ts.contains("WI"))
			termNum = "1";
		else if (ts.contains("SP"))
			termNum = "2";
		else if (ts.contains("SU"))
			termNum = "3";
		else if (ts.contains("FA") || ts.contains("AU"))
			termNum = "4";
		else
			throw new IllegalArgumentException("Invalid term " + term);
		return getAtpFromNumTermAndYear(termNum, year);
	}

	public static String getAtpFromNumTermAndYear(String term, String year) {
		int ty = Integer.parseInt(year);
		String type;
		int tmo;
		if ("1".equals(term)) {
			type = "kuali.atp.type.Winter";
			tmo = Calendar.JANUARY;
		} else if ("2".equals(term)) {
			type = "kuali.atp.type.Spring";
			tmo = Calendar.APRIL;
		} else if ("3".equals(term)) {
			type = "kuali.atp.type.Summer";
			tmo = Calendar.JULY;
		} else if ("4".equals(term)) {
			type = "kuali.atp.type.Fall";
			tmo = Calendar.OCTOBER;
		} else
			throw new IllegalArgumentException("Invalid term " + term);
		Calendar cal = new GregorianCalendar(ty, tmo, 1);
		List<AtpInfo> atps;
		try {
			atps = KsapFrameworkServiceLocator.getAtpService()
					.getAtpsByDateAndType(cal.getTime(), type, getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in ATP ID lookup", t);
		}
		assert atps != null && atps.size() == 1 : "Expected exactly one term for "
				+ type + " and date " + cal.getTime();
		return atps.get(0).getId();
	}

	/**
	 * Gets term name as "Spring 2012" given an ATP ID.
	 * 
	 * @return
	 */
	public static String atpIdToTermName(String atpId) {
		String[] termYear = atpIdToTermNameAndYear(atpId);
		return (termYear[0] + " " + termYear[1]);
	}

	/**
	 * Returns true if an ATP is considered present or greater in the context of
	 * WHAT? Otherwise, false.
	 * 
	 * @param atpId
	 * @return
	 */
	public static boolean isAtpSetToPlanning(String atpId) {
		List<TermInfo> planningTermInfo;
		TermInfo comparingTerm;
		try {
			AcademicCalendarService acal = KsapFrameworkServiceLocator
					.getAcademicCalendarService();
			planningTermInfo = acal.searchForTerms(QueryByCriteria.Builder
					.fromPredicates(equalIgnoreCase("query",
							PlanConstants.PLANNING)), getContext());
			comparingTerm = acal.getTerm(atpId, getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in ATP ID lookup", t);
		}
		assert planningTermInfo != null && planningTermInfo.size() >= 1 : "Expected at least one planning term";
		return comparingTerm.getStartDate().after(
				planningTermInfo.get(0).getStartDate());
	}

	/**
	 * Returns true if an ATP is considered present or greater in the context of
	 * WHAT? Otherwise, false.
	 * 
	 * @param atpId
	 * @return
	 */
	public static boolean isAtpCompletedTerm(String atpId) {
		List<TermInfo> inProgressTermInfo;
		TermInfo comparingTerm;
		try {
			AcademicCalendarService acal = KsapFrameworkServiceLocator
					.getAcademicCalendarService();
			inProgressTermInfo = acal.searchForTerms(QueryByCriteria.Builder
					.fromPredicates(equalIgnoreCase("query",
							PlanConstants.INPROGRESS)), getContext());
			comparingTerm = acal.getTerm(atpId, getContext());
		} catch (Throwable t) {
			if (t instanceof RuntimeException)
				throw (RuntimeException) t;
			if (t instanceof Error)
				throw (Error) t;
			throw new IllegalStateException(
					"Unexpected error in ATP ID lookup", t);
		}
		assert inProgressTermInfo != null && inProgressTermInfo.size() >= 1 : "Expected at least one in progress term";
		return comparingTerm.getStartDate().before(
				inProgressTermInfo.get(0).getStartDate());
	}

	public static boolean isAtpIdFormatValid(String atpId) {
		try {
			return KsapFrameworkServiceLocator.getAcademicCalendarService()
					.getTerm(atpId, getContext()) != null;
		} catch (Throwable t) {
			return false;
		}
	}

	public static void addServiceError(String propertyName) {
		String[] params = {};
		GlobalVariables.getMessageMap().putWarning(propertyName,
				PlanConstants.ERROR_TECHNICAL_PROBLEMS, params);
	}

}
