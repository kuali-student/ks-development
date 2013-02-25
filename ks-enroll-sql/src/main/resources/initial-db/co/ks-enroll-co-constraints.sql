

ALTER TABLE KSEN_CO_AO_CLUSTER_ATTR
    ADD CONSTRAINT KSEN_CO_AO_CLUSTER_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_CO_AO_CLUSTER (ID)
/


ALTER TABLE KSEN_CO_AO_CLUSTER_SET
    ADD CONSTRAINT KSEN_CO_AO_CLUSTER_SET_FK1 FOREIGN KEY (AO_CLUSTER_ID)
    REFERENCES KSEN_CO_AO_CLUSTER (ID)
/


ALTER TABLE KSEN_CO_AO_CLUSTER_SET_AO
    ADD CONSTRAINT KSEN_CO_AOC_SET_AO_FK1 FOREIGN KEY (AOC_SET_ID)
    REFERENCES KSEN_CO_AO_CLUSTER_SET (ID)
/



ALTER TABLE KSEN_CO_SEAT_POOL_DEFN_ATTR
    ADD CONSTRAINT KSEN_CO_SPD_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_CO_SEAT_POOL_DEFN (ID)
/

