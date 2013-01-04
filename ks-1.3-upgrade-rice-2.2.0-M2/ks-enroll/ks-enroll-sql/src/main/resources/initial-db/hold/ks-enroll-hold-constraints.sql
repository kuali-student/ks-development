CREATE  INDEX KSEN_HOLD_I1 ON KSEN_HOLD
(HOLD_TYPE   ASC)
/



CREATE  INDEX KSEN_HOLD_I2 ON KSEN_HOLD
(PERS_ID   ASC,ISSUE_ID   ASC)
/



CREATE  INDEX KSEN_HOLD_IF1 ON KSEN_HOLD
(ISSUE_ID   ASC)
/



CREATE  INDEX KSEN_HOLD_ATTR_IF1 ON KSEN_HOLD_ATTR
(OWNER_ID   ASC)
/



CREATE  INDEX KSEN_HOLD_ISSUE_I1 ON KSEN_HOLD_ISSUE
(HOLD_ISSUE_TYPE   ASC)
/



CREATE  INDEX KSEN_HOLD_ISSUE_I2 ON KSEN_HOLD_ISSUE
(ORG_ID   ASC)
/



CREATE  INDEX KSEN_HOLD_ISSUE_ATTR_IF1 ON KSEN_HOLD_ISSUE_ATTR
(OWNER_ID   ASC)
/



ALTER TABLE KSEN_HOLD
	ADD (CONSTRAINT KSEN_HOLD_FK1 FOREIGN KEY (ISSUE_ID) REFERENCES KSEN_HOLD_ISSUE (ID))
/



ALTER TABLE KSEN_HOLD_ATTR
	ADD (CONSTRAINT KSEN_HOLD_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_HOLD (ID))
/



ALTER TABLE KSEN_HOLD_ISSUE_ATTR
	ADD (CONSTRAINT KSEN_HOLD_ISSUE_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_HOLD_ISSUE (ID))
/



