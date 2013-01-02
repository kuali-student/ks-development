package org.kuali.student.lum.workflow.qualifierresolver;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kew.engine.RouteContext;
import org.kuali.rice.kew.engine.node.RouteNodeUtils;
import org.kuali.rice.kim.bo.types.dto.AttributeSet;
import org.kuali.rice.student.bo.KualiStudentKimAttributes;

public class OrganizationQualifierResolver extends
		AbstractOrganizationServiceQualifierResolver {
    protected static final String ROUTE_NODE_XML_ORG_ID_QUALIFIER_KEY = "organizationIdQualifierKey";
    protected static final String ROUTE_NODE_XML_USE_NON_DERIVED_ROLES = "useNonDerivedRoles";
    
	@Override
	public List<AttributeSet> resolve(RouteContext context) {
        List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();
        String orgIdKey = getNodeSpecificOrganizationIdAttributeSetKey(context);
        for (String orgId : getOrganizationIdsFromDocumentContent(context)) {
        	AttributeSet attributeSet = new AttributeSet();
        	attributeSet.put(orgIdKey, orgId);
        	attributeSet.put(KualiStudentKimAttributes.QUALIFICATION_ORG_ID, orgId);
        	attributeSets.add(attributeSet);
        }
        return attributeSets;
	}
	
    public String getNodeSpecificOrganizationIdAttributeSetKey(RouteContext context) {
        String organizationIdFieldKey = RouteNodeUtils.getValueOfCustomProperty(context.getNodeInstance().getRouteNode(), ROUTE_NODE_XML_ORG_ID_QUALIFIER_KEY);
        if (StringUtils.isBlank(organizationIdFieldKey)) {
            if (usesNonDerivedOrganizationRoles(context)) {
                throw new RuntimeException("Cannot find required XML element '" + ROUTE_NODE_XML_ORG_ID_QUALIFIER_KEY + "' on the Route Node XML configuration.");
            }
        }
        return organizationIdFieldKey;
    }
    
    public Boolean usesNonDerivedOrganizationRoles(RouteContext context) {
        String useNonDerivedOrganizationRoles = RouteNodeUtils.getValueOfCustomProperty(context.getNodeInstance().getRouteNode(), ROUTE_NODE_XML_USE_NON_DERIVED_ROLES);
        if (StringUtils.isNotBlank(useNonDerivedOrganizationRoles)) {
            return Boolean.valueOf(useNonDerivedOrganizationRoles);
        }
        return true;
    }
}
