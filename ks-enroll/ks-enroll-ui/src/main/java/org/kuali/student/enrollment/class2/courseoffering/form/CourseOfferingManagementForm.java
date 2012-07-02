package org.kuali.student.enrollment.class2.courseoffering.form;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.enrollment.acal.dto.TermInfo;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;

import java.util.ArrayList;
import java.util.List;

public class CourseOfferingManagementForm extends UifFormBase {
    private String termCode;
    private TermInfo termInfo;
    private String courseOfferingCode;
    private String subjectCode;
    private String radioSelection;
    private String inputCode;
    private String activityActionType;
    private List<CourseOfferingInfo> courseOfferingList;
    private CourseOfferingInfo theCourseOffering;

    private List<ActivityOfferingWrapper> activityWrapperList;
    private List<ActivityOfferingWrapper> selectedToDeleteList;


    //For Adding Activity
    private String formatIdForNewAO;

    private String activityIdForNewAO;
    private String noOfActivityOfferings;

    public CourseOfferingManagementForm (){
        courseOfferingList = new ArrayList<CourseOfferingInfo>();
        activityWrapperList = new ArrayList<ActivityOfferingWrapper>();
        selectedToDeleteList = new ArrayList<ActivityOfferingWrapper>();
//        haveValidTerm = false;
    }

    public String getTermCode(){
        return termCode;
    }

    public void setTermCode(String termCode){
        this.termCode = termCode;
    }

    public TermInfo getTermInfo(){
        return termInfo;    
    }
    
    public void setTermInfo(TermInfo termInfo){
        this.termInfo = termInfo;
    }
    
    public String getCourseOfferingCode(){
        return courseOfferingCode;
    }

    public void setCourseOfferingCode(String courseOfferingCode){
        this.courseOfferingCode = courseOfferingCode;
    }
    
    public String getSubjectCode(){
        return subjectCode;
    }
    
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    
    public String getRadioSelection(){
        return radioSelection;
    } 
    
    public void setRadioSelection(String radioSelection){
        this.radioSelection = radioSelection;
    }
    
    public String getInputCode(){
        return inputCode;
    }
    
    public void setInputCode(String inputCode){
        this.inputCode = inputCode;
    }

    public String getActivityActionType() {
        return activityActionType;
    }

    public void setActivityActionType(String activityActionType) {
        this.activityActionType = activityActionType;
    }

    public List<CourseOfferingInfo> getCourseOfferingList(){
        return courseOfferingList;
    }
    
    public void setCourseOfferingList(List<CourseOfferingInfo> courseOfferingList) {
        this.courseOfferingList = courseOfferingList;
    }
    
    public CourseOfferingInfo getTheCourseOffering(){
        return theCourseOffering;
    }

    public void setTheCourseOffering(CourseOfferingInfo theCourseOffering)  {
        this.theCourseOffering = theCourseOffering;
    }

    public String getNoOfActivityOfferings() {
        return noOfActivityOfferings;
    }

    public void setNoOfActivityOfferings(String noOfActivityOfferings) {
        this.noOfActivityOfferings = noOfActivityOfferings;
    }

    public List<ActivityOfferingWrapper> getActivityWrapperList() {
        return activityWrapperList;
    }

    public void setActivityWrapperList(List<ActivityOfferingWrapper> activityWrapperList) {
        this.activityWrapperList = activityWrapperList;
    }

    public List<ActivityOfferingWrapper> getSelectedToDeleteList() {
        return selectedToDeleteList;
    }

    public void setSelectedToDeleteList(List<ActivityOfferingWrapper> selectedToDeleteList) {
        this.selectedToDeleteList = selectedToDeleteList;
    }

    public String getFormatIdForNewAO() {
        return formatIdForNewAO;
    }

    public void setFormatIdForNewAO(String formatIdForNewAO) {
        this.formatIdForNewAO = formatIdForNewAO;
    }

    public String getActivityIdForNewAO() {
        return activityIdForNewAO;
    }

    public void setActivityIdForNewAO(String activityIdForNewAO) {
        this.activityIdForNewAO = activityIdForNewAO;
    }

}
