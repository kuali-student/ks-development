--
-- Copyright 2011 The Kuali Foundation Licensed under the
-- Educational Community License, Version 2.0 (the "License"); you may
-- not use this file except in compliance with the License. You may
-- obtain a copy of the License at
--
-- http://www.osedu.org/licenses/ECL-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an "AS IS"
-- BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
-- or implied. See the License for the specific language governing
-- permissions and limitations under the License.
--

//AtpStateEntity
INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.state.Draft', 'Draft', 'Indicates that this Time Period is just tentative', 0)
INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.state.Official', 'Official', 'Indicates that this Time Period has been established', 0)

INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.milestone.state.Draft', 'Draft', 'Indicates that this milestone is just tentative', 0)
INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.milestone.state.Official', 'Official', 'Indicates that this milestone has been established', 0)

INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.atp.relation.state.active', 'Active', 'Indicates that this Atp-Atp relation is active', 0)
INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.atp.relation.state.inactive', 'Inactive', 'Indicates that this Atp-Atp relation is inactive', 0)

INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.milestone.relation.state.active', 'Active', 'Indicates that this Atp-Milestone relation is active', 0)
INSERT INTO KSEN_ATP_STATE (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.milestone.relation.state.inactive', 'Inactive', 'Indicates that this Atp-Milestone relation is inactive', 0)

//AtpTypeEntity
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.AcademicCalendar', 'Academic Calendar', 'Academic Calendar', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.CampusCalendar', 'Campus Calendar', 'Campus Calendar', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Fall', 'Fall', 'Fall Semester', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Spring', 'Spring', 'Spring Semester', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.AY', 'AY', 'Full Academic Year', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.FY', 'FY', 'Fiscal Year', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Holiday', 'Holiday', 'Holiday', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.SpringBreak', 'SpringBreak', 'Spring Break', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Thanksgiving', 'Thanksgiving', 'Thanksgiving', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.HalfFall1', 'Fall Half-Semester 1', 'Fall Half-Semester 1', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.HalfFall2', 'Fall Half-Semester 2', 'Fall Half-Semester 2', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.HalfSpring1', 'Spring Half-Semester 1', 'Spring Half-Semester 1', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.HalfSpring2', 'Spring Half-Semester 1', 'Spring Half-Semester 2', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Mini-mester1A', 'Mini Semester 1A', 'Mini Semester 1A', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Mini-mester1B', 'Mini Semester 1B', 'Mini Semester 1B', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Mini-mester2C', 'Mini Semester 2C', 'Mini Semester 2C', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Mini-mester2D', 'Mini Semester 2D', 'Mini Semester 2D', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Session1', 'Session 1', 'Session 1', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Session2', 'Session 2', 'Session 2', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.SessionG1', 'Session G1', 'Session G1', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.SessionG2', 'Session G2', 'Session G2', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Summer', 'Summer', 'Summer Semester', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.SummerEve', 'Summer Eve', 'Summer Eve', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Winter', 'Winter', 'Winter', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.type.Adhoc', 'Ad hoc', 'Ad hoc', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.AdvanceRegistrationPeriod', 'Advance Registration Period', 'Advance Registration Period', 0) 
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.RegistrationPeriod', 'Registration Period', 'Registration Period', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.DropDate', 'Drop Date', 'Drop Period Ends', 0)
INSERT INTO KSEN_ATP_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.GradesDue', 'Grades Due', 'Grades Due', 0)

//AtpRichTextEntity
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-101', '<p>Desc 101</p>', 'Desc 101',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-102', '<p>Desc 102</p>', 'Desc 102',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-103', '<p>Desc 103</p>', 'Desc 103',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-104', '<p>Desc 104</p>', 'Desc 104',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-105', '<p>Desc 105</p>', 'Desc 105',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-106', '<p>Desc 106</p>', 'Desc 106',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-107', '<p>Desc 107</p>', 'Desc 107',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-108', '<p>Desc 108</p>', 'Desc 108',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-201', '<p>Desc 2</p>', 'Desc 2',0)
INSERT INTO KSEN_RICH_TEXT_T (ID, FORMATTED, PLAIN,VER_NBR) VALUES ('RICHTEXT-301', '<p>Desc 3</p>', 'Desc 3',0)

//AtpEntity
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testAtpId1', 'testAtp1', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Draft', 'RICHTEXT-101', 0)
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testAtpId2', 'testAtp2', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.CampusCalendar', 'kuali.atp.state.Draft', 'RICHTEXT-102', 0)
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testDeleteAtpId1', 'testDeleteAtp1', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.CampusCalendar', 'kuali.atp.state.Draft', 'RICHTEXT-103', 0)
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testDeleteAtpId2', 'testDeleteAtp2', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.CampusCalendar', 'kuali.atp.state.Draft', 'RICHTEXT-104', 0)
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testTermId1', 'testTerm1', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Draft', 'RICHTEXT-201', 0)
INSERT INTO KSEN_ATP (ID, NAME, START_DT, END_DT, ATP_TYPE_ID, ATP_STATE_ID, RT_DESCR_ID, VER_NBR) VALUES ('testTermId2', 'testTerm2', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.Spring', 'kuali.atp.state.Draft', 'RICHTEXT-301', 0)

//AtpAtpRelationTypeEntity
INSERT INTO KSEN_ATPATP_RELTN_TYPE (TYPE_KEY, NAME, TYPE_DESC, VER_NBR) values ('kuali.atp.atp.relation.includes', 'kuali.atp.atp.relation.includes', 'kuali.atp.atp.relation.includes', 0)
INSERT INTO KSEN_ATPATP_RELTN_TYPE (TYPE_KEY, NAME, TYPE_DESC, VER_NBR) values ('kuali.atp.atp.relation.associated', 'kuali.atp.atp.relation.associated', 'kuali.atp.atp.relation.associated', 0)

// AtpAtpRelationEntity
INSERT INTO KSEN_ATPATP_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, ATP_RELTN_TYPE_ID, RELATED_ATP_ID) VALUES ('ATPATPREL-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.associated', 'testAtpId2')
INSERT INTO KSEN_ATPATP_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, ATP_RELTN_TYPE_ID, RELATED_ATP_ID) VALUES ('ATPATPREL-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testTermId1')
INSERT INTO KSEN_ATPATP_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, ATP_RELTN_TYPE_ID, RELATED_ATP_ID) VALUES ('ATPATPREL-3', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testTermId1', 'kuali.atp.atp.relation.includes', 'testTermId2')
INSERT INTO KSEN_ATPATP_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, ATP_RELTN_TYPE_ID, RELATED_ATP_ID) VALUES ('ATPATPREL-4', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testDeleteAtpId1')
INSERT INTO KSEN_ATPATP_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, ATP_RELTN_TYPE_ID, RELATED_ATP_ID) VALUES ('ATPATPREL-5', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testDeleteAtpId2')

// MilestoneTypeEntity
INSERT INTO KSEN_MSTONE_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.AdvanceRegistrationPeriod', 'Advance Registration Period', 'Advance Registration Period', 0) 
INSERT INTO KSEN_MSTONE_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.RegistrationPeriod', 'Registration Period', 'Registration Period', 0)
INSERT INTO KSEN_MSTONE_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.DropDate', 'Drop Date', 'Drop Period Ends', 0)
INSERT INTO KSEN_MSTONE_TYPE(TYPE_KEY, NAME, TYPE_DESC, VER_NBR) VALUES ('kuali.atp.milestone.GradesDue', 'Grades Due', 'Grades Due', 0)

// MilestoneEntity
INSERT INTO KSEN_MSTONE(ID, NAME, START_DT, END_DT, MILESTONE_TYPE_ID, MILESTONE_STATE_ID, IS_ALL_DAY, IS_DATE_RANGE, RT_DESCR_ID, VER_NBR) values ('testId', 'testId', {ts '2011-07-10 00:00:00.0'}, {ts '2011-07-20 00:00:00.0'}, 'kuali.atp.milestone.AdvanceRegistrationPeriod', 'kuali.milestone.state.Draft', 0, 1, 'RICHTEXT-105', 0)
INSERT INTO KSEN_MSTONE(ID, NAME, START_DT, END_DT, MILESTONE_TYPE_ID, MILESTONE_STATE_ID, IS_ALL_DAY, IS_DATE_RANGE, RT_DESCR_ID, VER_NBR) values ('testId2', 'testId2', {ts '2011-08-01 00:00:00.0'}, {ts '2011-10-01 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Draft', 0, 1, 'RICHTEXT-106', 0)
INSERT INTO KSEN_MSTONE(ID, NAME, START_DT, END_DT, MILESTONE_TYPE_ID, MILESTONE_STATE_ID, IS_ALL_DAY, IS_DATE_RANGE, RT_DESCR_ID, VER_NBR) values ('testId3', 'testId3', {ts '2011-11-01 00:00:00.0'}, null, 'kuali.atp.milestone.DropDate', 'kuali.milestone.state.Draft', 1, 0, 'RICHTEXT-107', 0)
INSERT INTO KSEN_MSTONE(ID, NAME, START_DT, END_DT, MILESTONE_TYPE_ID, MILESTONE_STATE_ID, IS_ALL_DAY, IS_DATE_RANGE, RT_DESCR_ID, VER_NBR) values ('testDeleteId', 'testDeleteId', {ts '2011-11-01 00:00:00.0'}, null, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Draft', 0, 0, 'RICHTEXT-108', 0)

// AtpMilestoneRelationTypeEntity
INSERT INTO KSEN_ATPMSTONE_RELTN_TYPE (TYPE_KEY, NAME, TYPE_DESC, VER_NBR) values ('kuali.atp.milestone.relation.owns', 'Owns', 'Indicates the ATP owns the specified milestone', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN_TYPE (TYPE_KEY, NAME, TYPE_DESC, VER_NBR) values ('kuali.atp.milestone.relation.reuses', 'Reuses', 'Indicates the ATP reuses the specified milestone that another ATP owns ', 0)

// AtpMilestoneRelationEntity
INSERT INTO KSEN_ATPMSTONE_RELTN (ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, MSTONE_ID, AM_RELTN_TYPE_ID) values ('ATPMSTONEREL-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.milestone.relation.state.active', 'testAtpId1', 'testId', 'kuali.atp.milestone.relation.owns')
INSERT INTO KSEN_ATPMSTONE_RELTN (ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, MSTONE_ID, AM_RELTN_TYPE_ID) values ('ATPMSTONEREL-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.milestone.relation.state.active', 'testAtpId2', 'testId2', 'kuali.atp.milestone.relation.owns')
INSERT INTO KSEN_ATPMSTONE_RELTN (ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, MSTONE_ID, AM_RELTN_TYPE_ID) values ('ATPMSTONEREL-3', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.milestone.relation.state.active', 'testDeleteAtpId1', 'testId', 'kuali.atp.milestone.relation.owns')
INSERT INTO KSEN_ATPMSTONE_RELTN (ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE_ID, ATP_ID, MSTONE_ID, AM_RELTN_TYPE_ID) values ('ATPMSTONEREL-4', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.milestone.relation.state.active', 'testDeleteAtpId2', 'testId2', 'kuali.atp.milestone.relation.owns')

//StateEntity
INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.state.Draft', 'Draft', 'kuali.atp.process', 'Indicates that this Time Period is just tentative', 0)
INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.state.Official', 'Official', 'kuali.atp.process', 'Indicates that this Time Period has been established', 0)

INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.milestone.state.Draft', 'Draft', 'kuali.milestone.process', 'Indicates that this milestone is just tentative', 0)
INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.milestone.state.Official', 'Official', 'kuali.milestone.process', 'Indicates that this milestone has been established', 0)

INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.atp.relation.state.active', 'Active', 'kuali.atp.atp.relation.process', 'Indicates that this Atp-Atp relation is active', 0)
INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.atp.relation.state.inactive', 'Inactive', 'kuali.atp.atp.relation.process', 'Indicates that this Atp-Atp relation is inactive', 0)

INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.milestone.relation.state.active', 'Active', 'kuali.atp.milestone.relation.process', 'Indicates that this Atp-Milestone relation is active', 0)
INSERT INTO KSEN_COMM_STATE (ID, NAME, PROCESS_KEY, DESCR, VER_NBR) VALUES ('kuali.atp.milestone.relation.state.inactive', 'Inactive', 'kuali.atp.milestone.relation.process', 'Indicates that this Atp-Milestone relation is inactive', 0)

//StateProcessEntity
INSERT INTO KSEN_STATE_PROCESS (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.process', 'kuali.atp.process', 'kuali atp state process', 0)
INSERT INTO KSEN_STATE_PROCESS (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.milestone.process', 'kuali.milestone.process', 'kuali milestone state process', 0)
INSERT INTO KSEN_STATE_PROCESS (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.atp.relation.process', 'kuali.atp.atp.relation.process', 'kuali atp-atp relation state process', 0)
INSERT INTO KSEN_STATE_PROCESS (ID, NAME, DESCR, VER_NBR) VALUES ('kuali.atp.milestone.relation.process', 'kuali.atp.milestone.relation.process', 'kuali atp-milestone relation state process', 0)

//StateProcessRelationEntity
INSERT INTO KSEN_STATEPROCESS_RELTN(ID, PROCESS_KEY, PRIOR_STATEKEY, NEXT_STATEKEY, VER_NBR)VALUES('PROCESS-1', 'kuali.atp.process', null, 'kuali.atp.state.Draft', 0)
INSERT INTO KSEN_STATEPROCESS_RELTN(ID, PROCESS_KEY, PRIOR_STATEKEY, NEXT_STATEKEY, VER_NBR)VALUES('PROCESS-2', 'kuali.atp.process', 'kuali.atp.state.Draft', 'kuali.atp.state.Official', 0)

// TypeTypeRelationEntity - TODO: move to object-URI-neutral sql file
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-0', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.precedes', 'kuali.atp.type.Fall', 'kuali.atp.type.Spring', 0, 'Fall precedes Spring')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.includes', 'kuali.atp.type.AY', 'kuali.atp.type.Fall', 0, 'Academic year contains semester')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.includes', 'kuali.atp.type.AY', 'kuali.atp.type.Spring', 1, 'Academic year contains semester')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-3', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.includes', 'kuali.atp.type.AY', 'kuali.atp.type.Summer', 2, 'Academic year contains semester')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-4', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.Holiday', 'kuali.atp.type.SpringBreak' , 0, 'Spring break is a holiday')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('TYPETYPEREL-5', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.Holiday', 'kuali.atp.type.Thanksgiving' , 0, 'Thanksgiving is a holiday')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Fall' , 0, 'kuali.atp.type.Fall is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.HalfFall1' , 0, 'kuali.atp.type.HalfFall1 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.3', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.HalfFall2' , 0, 'kuali.atp.type.HalfFall2 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.4', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.HalfSpring1' , 0, 'kuali.atp.type.HalfSpring1 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.5', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.HalfSpring2' , 0, 'kuali.atp.type.HalfSpring2 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.6', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Mini-mester1A' , 0, 'kuali.atp.type.Mini-mester1A is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.7', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Mini-mester1B' , 0, 'kuali.atp.type.Mini-mester1B is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.8', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Mini-mester2C' , 0, 'kuali.atp.type.Mini-mester2C is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.9', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Mini-mester2D' , 0, 'kuali.atp.type.Mini-mester2D is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.10', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Session1' , 0, 'kuali.atp.type.Session1 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.11', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Session2' , 0, 'kuali.atp.type.Session2 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.12', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.SessionG1' , 0, 'kuali.atp.type.SessionG1 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.13', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.SessionG2' , 0, 'kuali.atp.type.SessionG2 is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.14', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Spring' , 0, 'kuali.atp.type.Spring is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.15', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.SpringBreak' , 0, 'kuali.atp.type.SpringBreak is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.16', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Summer' , 0, 'kuali.atp.type.Summer is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.17', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.SummerEve' , 0, 'kuali.atp.type.SummerEve is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.18', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Winter' , 0, 'kuali.atp.type.Winter is a type of Term')
INSERT INTO KSEN_TYPETYPE_RELTN(ID, VER_NBR, EFF_DT, EXPIR_DT, TYPETYPE_RELATION_TYPE, OWNER_TYPE_ID, RELATED_TYPE_ID, RANK, NAME) values ('kuali.termtype.group.member.19', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.group', 'kuali.atp.type.group.term', 'kuali.atp.type.Adhoc' , 0, 'kuali.atp.type.Adhoc :is a type of Term')

// TypeEntity
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.AcademicCalendar', 'Academic Calendar', 'Academic Calendar', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.CampusCalendar', 'Campus Calendar', 'Campus Calendar', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.Fall', 'Fall', 'Fall Semester', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.Spring', 'Spring', 'Spring Semester', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.AY', 'AY', 'Full Academic Year', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.FY', 'FY', 'Fiscal Year', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.Holiday', 'Holiday', 'Holiday', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.SpringBreak', 'SpringBreak', 'Spring Break', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.type.Thanksgiving', 'Thanksgiving', 'Thanksgiving', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.AdvanceRegistrationPeriod', 'Advance Registration Period', 'Advance Registration Period', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0) 
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.RegistrationPeriod', 'Registration Period', 'Registration Period', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.DropDate', 'Drop Date', 'Drop Period Ends', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.GradesDue', 'Grades Due', 'Grades Due', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.AdvanceRegistrationPeriod', 'Advance Registration Period', 'Advance Registration Period', 0) 
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.RegistrationPeriod', 'Registration Period', 'Registration Period', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.DropDate', 'Drop Date', 'Drop Period Ends', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) VALUES ('kuali.atp.milestone.GradesDue', 'Grades Due', 'Grades Due', 'http://student.kuali.org/wsdl/atp/MilestoneInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.atp.relation.includes', 'kuali.atp.atp.relation.includes', 'kuali.atp.atp.relation.includes', 'http://student.kuali.org/wsdl/atp/AtpAtpRelationInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.atp.relation.associated', 'kuali.atp.atp.relation.associated', 'kuali.atp.atp.relation.associated', 'http://student.kuali.org/wsdl/atp/AtpAtpRelationInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.atp.relation.precedes', 'kuali.atp.atp.relation.precedes', 'kuali.atp.atp.relation.precedes', 'http://student.kuali.org/wsdl/atp/AtpAtpRelationInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.milestone.relation.owns', 'Owns', 'Indicates the ATP owns the specified milestone', 'http://student.kuali.org/wsdl/atp/AtpMilestoneRelationInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.milestone.relation.reuses', 'Reuses', 'Indicates the ATP reuses the specified milestone that another ATP owns ', 'http://student.kuali.org/wsdl/atp/AtpMilestoneRelationInfo', 0)
--
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Fall', 'Fall', 'Fall', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.HalfFall1', 'Half Fall 1', 'Half Fall 1', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.HalfFall2', 'Half Fall 2', 'Half Fall 2', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.HalfSpring1', 'Half Spring 1', 'Half Spring 1', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.HalfSpring2', 'Half Spring 2', 'Half Spring 2', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Mini-mester1A', 'Mini-mester 1A', 'Mini-mester 1A', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Mini-mester1B', 'Mini-mester 1B', 'Mini-mester 1B', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Mini-mester2C', 'Mini-mester 2C', 'Mini-mester 2C', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Mini-mester2D', 'Mini-mester 2D', 'Mini-mester 2D', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Session1', 'Session 1', 'Session 1', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Session2', 'Session 2', 'Session 2', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.SessionG1', 'Session G1', '', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.SessionG2', 'Session G2', 'Session G2', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Spring', 'Spring', 'Spring', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.SpringBreak', 'Spring Break', 'Spring Break', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Summer', 'Summer', 'Summer', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.SummerEve', 'Summer Eve', 'Summer Eve', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Winter', 'Winter', 'Winter', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)
--INSERT INTO KSEN_TYPE(TYPE_KEY, NAME, TYPE_DESC, REF_OBJECT_URI, VER_NBR) values ('kuali.atp.type.Adhoc', 'Ad hoc', 'Ad hoc', 'http://student.kuali.org/wsdl/atp/AtpInfo', 0)