--Namespace
insert into KRCR_NMSPC_T (NMSPC_CD, OBJ_ID, VER_NBR, NM, ACTV_IND, APPL_ID) values ('KS-ENR', SYS_GUID(), 1, 'Kuali Student Enrollment', 'Y', 'STUDENT')
/

--Permissions
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Open View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Open Views for Course Offering', 'Allows the user to Open Views for Course Offering', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Views for Course Offering', 'Allows the user to Edit Views for Course Offering', 'Y')
/
/*
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Groups for searchInputPage', 'Allows the user to View Groups for searchInputPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Groups for searchInputPage', 'Allows the user to Edit Groups for searchInputPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Groups for manageCourseOfferingsPage', 'Allows the user to View Groups for manageCourseOfferingsPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Groups for manageCourseOfferingsPage', 'Allows the user to Edit Groups for manageCourseOfferingsPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Groups for manageActivityOfferingsPage', 'Allows the user to View Groups for manageActivityOfferingsPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Groups for manageActivityOfferingsPage', 'Allows the user to Edit Groups for manageActivityOfferingsPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Groups for copyCourseOfferingPage', 'Allows the user to View Groups for copyCourseOfferingPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Groups for copyCourseOfferingPage', 'Allows the user to Edit Groups for copyCourseOfferingPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Group for KS-CourseOfferingManagement-CourseOfferingSelectAll', 'Allows the user to View Group for KS-CourseOfferingManagement-CourseOfferingSelectAll', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Field' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Field for KS-CourseOfferingManagement-ActivityOfferingListSection-IsChecked', 'Allows the user to View Field for KS-CourseOfferingManagement-ActivityOfferingListSection-IsChecked', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Group for KS-CourseOfferingManagement-SelectedActivityOfferingSection', 'Allows the user to View Group for KS-CourseOfferingManagement-SelectedActivityOfferingSection', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Group for KS-CourseOfferingManagement-AddActivityOfferingSection', 'Allows the user to View Group for KS-CourseOfferingManagement-AddActivityOfferingSection', 'Y')
/
*/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Open View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Open Views for Manage Registration Groups', 'Allows the user to Open Views for  Manage Registration Groups', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Views for Manage Registration Groups', 'Allows the user to Edit Views for  Manage Registration Groups', 'Y')
/
/*
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Group for KS-CourseOfferingManagement-CourseOfferingManageRegGroups', 'Allows the user to View Group for  KS-CourseOfferingManagement-CourseOfferingManageRegGroups', 'Y')
/
*/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Open View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Open Views for Create Course Offering', 'Allows the user to Open Views for Create Course Offering', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'Edit View' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'Edit Views for Create Course Offering', 'Allows the user to Edit Views for Create Course Offering', 'Y')
/
/*
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values (KRIM_PERM_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KR-KRAD'), 'KS-ENR', 'View Group for KS-CourseOfferingManagement-CourseOfferingResultSectionCreateCourse', 'Allows the user to View Group for  KS-CourseOfferingManagement-CourseOfferingResultSectionCreateCourse', 'Y')
/
*/


--Permission Details
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Open Views for Course Offering' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'courseOfferingManagementView')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Views for Course Offering' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'courseOfferingManagementView')
/
/*
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Groups for searchInputPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'searchInputPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Groups for searchInputPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'searchInputPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Groups for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'manageCourseOfferingsPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Groups for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'manageCourseOfferingsPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Groups for manageActivityOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'manageActivityOfferingsPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Groups for manageActivityOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'manageActivityOfferingsPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Groups for copyCourseOfferingPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'copyCourseOfferingPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Groups for copyCourseOfferingPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'copyCourseOfferingPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Group for KS-CourseOfferingManagement-CourseOfferingSelectAll' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'KS-CourseOfferingManagement-CourseOfferingSelectAll')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Field for KS-CourseOfferingManagement-ActivityOfferingListSection-IsChecked' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'courseOfferingManagementView')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Field for KS-CourseOfferingManagement-ActivityOfferingListSection-IsChecked' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'propertyName' and nmspc_cd = 'KR-NS'), 'isChecked')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Group for KS-CourseOfferingManagement-SelectedActivityOfferingSection' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'KS-CourseOfferingManagement-SelectedActivityOfferingSection')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Group for KS-CourseOfferingManagement-AddActivityOfferingSection' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'KS-CourseOfferingManagement-AddActivityOfferingSection')
/
*/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Open Views for Manage Registration Groups' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'manageRegistrationGroupsView')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Views for Manage Registration Groups' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'manageRegistrationGroupsView')
/
/*
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Group for KS-CourseOfferingManagement-CourseOfferingManageRegGroups' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'KS-CourseOfferingManagement-CourseOfferingManageRegGroups')
/
*/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Open Views for Create Course Offering' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'createCourseOfferingPage')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'Edit Views for Create Course Offering' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'createCourseOfferingPage')
/
/*
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values (KRIM_ATTR_DATA_ID_S.NEXTVAL, SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Group for KS-CourseOfferingManagement-CourseOfferingResultSectionCreateCourse' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT MIN(TO_NUMBER(kim_attr_defn_id)) from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'KS-CourseOfferingManagement-CourseOfferingResultSectionCreateCourse')
/
*/