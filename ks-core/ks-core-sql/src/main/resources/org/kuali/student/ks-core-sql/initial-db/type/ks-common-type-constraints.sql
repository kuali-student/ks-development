

ALTER TABLE KSEN_TYPETYPE_RELTN
    ADD CONSTRAINT KSEN_TYPETYPE_RELTN_FK1 FOREIGN KEY (OWNER_TYPE_ID)
    REFERENCES KSEN_TYPE (TYPE_KEY)
/

ALTER TABLE KSEN_TYPETYPE_RELTN
    ADD CONSTRAINT KSEN_TYPETYPE_RELTN_FK2 FOREIGN KEY (RELATED_TYPE_ID)
    REFERENCES KSEN_TYPE (TYPE_KEY)
/


ALTER TABLE KSEN_TYPETYPE_RELTN_ATTR
    ADD CONSTRAINT KSEN_TYPETYPE_RELTN_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_TYPETYPE_RELTN (ID)
/


ALTER TABLE KSEN_TYPE_ATTR
    ADD CONSTRAINT KSEN_TYPE_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_TYPE (TYPE_KEY)
/

