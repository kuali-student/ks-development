package org.kuali.student.core.enumeration.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.kuali.student.core.enumeration.EnumerationException;
import org.kuali.student.core.enumeration.dao.EnumerationManagementDAO;
import org.kuali.student.core.enumeration.entity.EnumeratedValueEntity;
import org.kuali.student.core.enumeration.entity.EnumerationMetaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EnumerationManagementDAOImpl implements EnumerationManagementDAO {
    private EntityManager entityManager;
    
    final static Logger logger = LoggerFactory.getLogger(EnumerationManagementDAOImpl.class);

    @PersistenceContext(name = "EnumerationManagement")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public EntityManager getEntityManager(){
        return this.entityManager; 
    }
    

	public List<EnumerationMetaEntity> findEnumerationMetas() {
    	List<EnumerationMetaEntity> metas = new ArrayList<EnumerationMetaEntity>();
    	try{
	        Query query = entityManager.createQuery("SELECT e FROM EnumerationMetaEntity e");
	        @SuppressWarnings("unchecked")	        
	        List<EnumerationMetaEntity> resultList = (List<EnumerationMetaEntity>) query.getResultList();
			metas = resultList;
    	}
        catch(Exception e){
	    	logger.error("findEnumerationMetas query failed.", e);
			throw new EnumerationException("findEnumerationMetas query failed.", e);
	    }
        return metas;
    }
    
    public EnumerationMetaEntity addEnumerationMeta(EnumerationMetaEntity entity){
    	try{
	        entityManager.persist(entity);
	        entity = entityManager.find(EnumerationMetaEntity.class, entity.getId());
		}
	    catch(Exception e){
	    	throw new EnumerationException("addEnumerationMeta query failed.", e);
	    }
        return entity;
    }
    
    public boolean removeEnumerationMeta(String enumerationKey){
        boolean removed = false;
        try{
	    	EnumerationMetaEntity meta = this.fetchEnumerationMeta(enumerationKey);
	        if(meta != null){
	        	entityManager.remove(meta);
	        	removed = true;
	        }
		}
	    catch(Exception e){
	    	logger.error("removeEnumerationMeta query failed.", e);
			throw new EnumerationException("removeEnumerationMeta query failed.", e);
	    }
	    	
	    return removed;
	}

    public EnumerationMetaEntity fetchEnumerationMeta(String enumerationKey) {
    	EnumerationMetaEntity em = null;
    	try{
	    	Query query = entityManager.createQuery("SELECT e FROM EnumerationMetaEntity e where e.enumerationKey = :key");
	        query.setParameter("key", enumerationKey);
	        
	        if(!query.getResultList().isEmpty()){
	        	em = (EnumerationMetaEntity)query.getResultList().get(0);
	        }else{
	            return null;
	        }
    	}
        catch(Exception e){
        	logger.error("fetchEnumerationMeta query failed.", e);
			throw new EnumerationException("fetchEnumerationMeta query failed.", e);
        }

        return em;
    }

    public EnumeratedValueEntity addEnumeratedValue(String enumerationKey, EnumeratedValueEntity value) {
    	try{
	        entityManager.persist(value);
	        value.setEnumerationKey(enumerationKey);
    	}
        catch(Exception e){
        	logger.error("addEnumeratedValue query failed.", e);
			throw new EnumerationException("addEnumeratedValue query failed.", e);
        }

        return value;
    }
    
    
    public EnumeratedValueEntity updateEnumeratedValue(String enumerationKey, String code, EnumeratedValueEntity enumeratedValueEntity) {
        //this.removeEnumeratedValue(enumerationKey, code);
        //this.addEnumeratedValue(enumerationKey, enumeratedValueEntity);
    	
    	//Query query = entityManager.createQuery("update EnumeratedValueEntity e set e.value = :value where e.enumerationKey = :key and e.code = :code");
        //query.setParameter("key", enumerationKey);
        //query.setParameter("code", code);
        //query.setParameter("value", enumeratedValueEntity.getValue());
        
        //query.executeUpdate();
    	EnumeratedValueEntity returnValue = null;
    	try{
	        
	    	List<EnumeratedValueEntity> list = this.fetchEnumeration(enumerationKey);
	        for(EnumeratedValueEntity e: list){
	        	if(e.getCode().equals(code)){
	        		e.setCode(enumeratedValueEntity.getCode());
	        		e.setEffectiveDate(enumeratedValueEntity.getEffectiveDate());
	        		e.setExpirationDate(enumeratedValueEntity.getExpirationDate());
	        		e.setEnumerationKey(enumerationKey);
	        		e.setSortKey(enumeratedValueEntity.getSortKey());
	        		e.setValue(enumeratedValueEntity.getValue());
	        		e.setAbbrevValue(enumeratedValueEntity.getAbbrevValue());
	        		e.setContextEntityList(enumeratedValueEntity.getContextEntityList());
	        		entityManager.merge(e);
	        		returnValue = e;
	        	}
	        }

    	}
        catch(Exception e){
			throw new EnumerationException("updateEnumeratedValue query failed.", e);
        }
        
    	//entityManager.merge(enumeratedValueEntity);
    	//for(ContextEntity c: enumeratedValueEntity.getContextEntityList()){
    		//entityManager.merge(c);
    	//}
/*
    	Query query = entityManager.createQuery(
	            "select e from EnumeratedValueEntity e JOIN e.contextEntityList c " +
	            "where e.enumerationKey = :enumerationKey "+
	            "and e.code = :code");
		query.setParameter("enumerationKey", enumerationKey);
        query.setParameter("code", code);
        Object obj = query.getResultList().get(0);
*/
        
        //return (EnumeratedValueEntity) obj;
        return returnValue;
    }
    
    public boolean removeEnumeratedValue(String enumerationKey, String code) {
        //Query query = entityManager.createQuery("delete from EnumeratedValueEntity e where e.enumerationKey = :key and e.code = :code");
        //query.setParameter("key", enumerationKey);
       // query.setParameter("code", code);
        boolean removed = false;
        try{
	    	List<EnumeratedValueEntity> list = this.fetchEnumeration(enumerationKey);
	        for(EnumeratedValueEntity e: list){
	        	if(e.getCode().equals(code)){
	        		entityManager.remove(e);
	        		removed = true;
	        	}
	        }
        }
		catch(Exception e){
			logger.error("removeEnumeratedValue query failed.", e);
			throw new EnumerationException("removeEnumeratedValue query failed.", e);
		}
        //query.executeUpdate();
        return removed;
    }
    
    
	public List<EnumeratedValueEntity> fetchEnumeration(String enumerationKey) {
		
		List<EnumeratedValueEntity> list = new ArrayList<EnumeratedValueEntity>();
		try{
			Query query = entityManager.createQuery(
		            "select e from EnumeratedValueEntity e " +
		            "where e.enumerationKey = :enumerationKey ");
			query.setParameter("enumerationKey", enumerationKey);
			@SuppressWarnings("unchecked")
			List<EnumeratedValueEntity> resultList = (List<EnumeratedValueEntity>)query.getResultList();
			list = resultList;
		}
		catch(Exception e){
			logger.error("fetchEnumeration query failed.", e);
			throw new EnumerationException("fetchEnumeration query failed.", e);
		}
		 
		return list;
	}
	public List<EnumeratedValueEntity> fetchEnumerationWithDate(String enumerationKey, Date contextDate) {
		
		List<EnumeratedValueEntity> list = new ArrayList<EnumeratedValueEntity>();
		try{
			Query query = entityManager.createQuery(
		            "select e from EnumeratedValueEntity e " +
		            "where e.effectiveDate <= :contextDate and " +
		            "(e.expirationDate is null or e.expirationDate >= :contextDate) and " +
		            "e.enumerationKey = :enumerationKey ");
			query.setParameter("enumerationKey", enumerationKey);
			query.setParameter("contextDate", contextDate);
		    @SuppressWarnings("unchecked")
			List<EnumeratedValueEntity> resultList = (List<EnumeratedValueEntity>)query.getResultList();
			list = resultList;
		}
		catch(Exception e){
			logger.error("fetchEnumerationWithDate query failed.", e);
			throw new EnumerationException("fetchEnumerationWithDate query failed.", e);
		}
		return list;
	}
	public List<EnumeratedValueEntity> fetchEnumerationWithContext(String enumerationKey, String enumContextKey, String contextValue) {
		
		List<EnumeratedValueEntity> list = new ArrayList<EnumeratedValueEntity>();
		try{
			Query query = entityManager.createQuery(
		            "select e from EnumeratedValueEntity e JOIN e.contextEntityList c " +
		            "where c.contextValue = :contextValue and " +
		            "c.contextKey = :enumContextKey and " +
		            "e.enumerationKey = :enumerationKey ");
			 query.setParameter("enumerationKey", enumerationKey);
			 query.setParameter("enumContextKey", enumContextKey);        
			 query.setParameter("contextValue", contextValue);
			 
			@SuppressWarnings("unchecked")
 		 	List<EnumeratedValueEntity> resultList = (List<EnumeratedValueEntity>)query.getResultList();
			list = resultList;
		}
		catch(Exception e){
			logger.error("fetchEnumerationWithContext query failed.", e);
			throw new EnumerationException("fetchEnumerationWithContext query failed.", e);
		}
		return list;
	}
	
	public List<EnumeratedValueEntity> fetchEnumerationWithContextAndDate(String enumerationKey, String enumContextKey, String contextValue,
			Date contextDate) {
    	
		List<EnumeratedValueEntity> list = new ArrayList<EnumeratedValueEntity>();
    	
		try{
	        Query query = entityManager.createQuery(
	                "select e from EnumeratedValueEntity e JOIN e.contextEntityList c " 
	                + "where e.effectiveDate <= :contextDate and " +
	                "(e.expirationDate is null or e.expirationDate >= :contextDate) and " + 
	                "c.contextValue = :contextValue and " + 
	                "c.contextKey = :enumContextKey and " +
	                "e.enumerationKey = :enumKey ");
	        query.setParameter("contextDate", contextDate);
	        query.setParameter("contextValue", contextValue);
	        query.setParameter("enumContextKey", enumContextKey);
	        query.setParameter("enumKey", enumerationKey);
	        @SuppressWarnings("unchecked")
	        List<EnumeratedValueEntity> resultList = (List<EnumeratedValueEntity>)query.getResultList();
			list = resultList;
		}
		catch(Exception e){
			logger.error("fetchEnumerationWithContextAndDate query failed.", e);
			throw new EnumerationException("fetchEnumerationWithContextAndDate query failed.", e);
		}
         
        return list;
	}
	
    /*
    public List<EnumeratedValueEntity> fetchEnumeration(String enumerationKey, String enumContextKey, String contextValue, Date contextDate) {
    	

    	
    	if(enumerationKey != null){
    		if(enumContextKey == null || contextValue == null){
    			//check to see if there is a date, return all results under these conditions if one does not exist
    			if(contextDate != null){
    				Query query = entityManager.createQuery(
    			            "select e from EnumeratedValueEntity e, ContextEntity c " +
    			            "where e.id = c.enumerationId and " +
    			            "e.effectiveDate < :contextDate and " +
    			            "e.expirationDate > :contextDate and " +
    			            "e.enumerationKey = :enumerationKey ");
    				 query.setParameter("enumerationKey", enumerationKey);
    				 query.setParameter("contextDate", contextDate);
    				 list = (List<EnumeratedValueEntity>)query.getResultList();
    			}
    			else{
    				Query query = entityManager.createQuery(
    			            "select e from EnumeratedValueEntity e, ContextEntity c " +
    			            "where e.id = c.enumerationId and " +
    			            "e.enumerationKey = :enumerationKey ");
    				 query.setParameter("enumerationKey", enumerationKey);
    				 list = (List<EnumeratedValueEntity>)query.getResultList();
    			}
    		}
    		//enumContextKey and contextValue are both not null
    		else{
    			//check to see if there is a date, return all results under these conditions if one does not exist
    			if(contextDate != null){
    				Query query = entityManager.createQuery(
    			            "select e from EnumeratedValueEntity e, ContextEntity c " +
    			            "where e.id = c.enumerationId and " +
    			            "e.effectiveDate < :contextDate and " +
    			            "e.expirationDate > :contextDate and " +
    			            "c.value = :contextValue and " +
    			            "c.key = :enumContextKey and " +
    			            "e.enumerationKey = :enumerationKey ");
    				 query.setParameter("enumerationKey", enumerationKey);
    				 query.setParameter("enumContextKey", enumContextKey);        
    				 query.setParameter("contextValue", contextValue);
    				 query.setParameter("contextDate", contextDate);
    				 list = (List<EnumeratedValueEntity>)query.getResultList();
    			}
    			else{
    				Query query = entityManager.createQuery(
    			            "select e from EnumeratedValueEntity e, ContextEntity c " +
    			            "where e.id = c.enumerationId and " +
    			            "c.value = :contextValue and " +
    			            "c.key = :enumContextKey and " +
    			            "e.enumerationKey = :enumerationKey ");
    				 query.setParameter("enumerationKey", enumerationKey);
    				 query.setParameter("enumContextKey", enumContextKey);        
    				 query.setParameter("contextValue", contextValue);
    				 list = (List<EnumeratedValueEntity>)query.getResultList();
    			}
    		}
    		
		    
    	}
 	


    }
      */ 
}
