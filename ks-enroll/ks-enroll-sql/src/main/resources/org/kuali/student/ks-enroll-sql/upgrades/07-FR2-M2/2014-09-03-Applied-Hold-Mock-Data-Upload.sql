--KSENROLL-14688: Upload Applied Hold data with 20 students
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.ELENAB',
  'kuali.hold.issue.academic.probation',
  'Student Hold',
  SYS_GUID(),
  'KS-7196',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.R.JEFFREYB',
  'kuali.hold.issue.academically.ineligible',
  'Student Hold',
  SYS_GUID(),
  'KS-1675',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.BETHA',
  'kuali.hold.issue.choose.degree',
  'Student Hold',
  SYS_GUID(),
  'KS-6279',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.ANNAH',
  'kuali.hold.issue.financial.ineligible',
  'Student Hold',
  SYS_GUID(),
  'KS-6509',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.R.JANEN',
  'kuali.hold.issue.fundamental.english',
  'Student Hold',
  SYS_GUID(),
  'KS-7603',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.DAVIDK',
  'kuali.hold.issue.fundamental.math',
  'Student Hold',
  SYS_GUID(),
  'KS-3272',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.BARBARAH',
  'kuali.hold.issue.last.attended',
  'Student Hold',
  SYS_GUID(),
  'KS-6573',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.L.VICTORP',
  'kuali.hold.issue.new.student.advising',
  'Student Hold',
  SYS_GUID(),
  'KS-4993',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.CYNTHIAD',
  'kuali.hold.issue.no.immunization.record',
  'Student Hold',
  SYS_GUID(),
  'KS-2563',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.CHARLESW1500',
  'kuali.hold.issue.student.athlete',
  'Student Hold',
  SYS_GUID(),
  'KS-2813',
  null,
  null,
  '1')
/
---Second 10 Students
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.BENJAMINN',
  'kuali.hold.issue.academic.probation',
  'Student Hold',
  SYS_GUID(),
  'KS-3515',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.CHARLESV',
  'kuali.hold.issue.academically.ineligible',
  'Student Hold',
  SYS_GUID(),
  'KS-6261',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.DENISEW',
  'kuali.hold.issue.choose.degree',
  'Student Hold',
  SYS_GUID(),
  'KS-8615',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.BLISSK',
  'kuali.hold.issue.financial.ineligible',
  'Student Hold',
  SYS_GUID(),
  'KS-3484',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.DENNISS',
  'kuali.hold.issue.fundamental.english',
  'Student Hold',
  SYS_GUID(),
  'KS-9137',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.R.JACOBW',
  'kuali.hold.issue.fundamental.math',
  'Student Hold',
  SYS_GUID(),
  'KS-5297',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.EMILYG',
  'kuali.hold.issue.last.attended',
  'Student Hold',
  SYS_GUID(),
  'KS-2014',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.DERYAC',
  'kuali.hold.issue.new.student.advising',
  'Student Hold',
  SYS_GUID(),
  'KS-4111',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.F.ANNC',
  'kuali.hold.issue.no.immunization.record',
  'Student Hold',
  SYS_GUID(),
  'KS-7442',
  null,
  null,
  '1')
/
insert into KSEN_HOLD
  (CREATEID,
   CREATETIME,
   DESCR_FORMATTED,
   DESCR_PLAIN,
   EFF_DT,
   EXPIR_DT,
   HOLD_STATE,
   HOLD_TYPE,
   ID,
   ISSUE_ID,
   NAME,
   OBJ_ID,
   PERS_ID,
   UPDATEID,
   UPDATETIME,
   VER_NBR)
values
  ('SYSTEMLOADER',
  SYSDATE,
  'This is a hold that is applied to a student.',
  'This is a hold that is applied to a student.',
  TO_DATE( '2012-01-1', 'YYYY-MM-DD' ),
  null,
  'kuali.hold.issue.state.active',
  'kuali.hold.type.student',
  'kuali.applied.hold.L.RYANA',
  'kuali.hold.issue.student.athlete',
  'Student Hold',
  SYS_GUID(),
  'KS-6748',
  null,
  null,
  '1')
/