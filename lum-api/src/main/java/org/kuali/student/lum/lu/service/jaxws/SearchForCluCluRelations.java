
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.4
 * Tue Feb 24 12:25:30 EST 2009
 * Generated source version: 2.1.4
 */

@XmlRootElement(name = "searchForCluCluRelations", namespace = "http://student.kuali.org/lum/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchForCluCluRelations", namespace = "http://student.kuali.org/lum/lu")

public class SearchForCluCluRelations {

    @XmlElement(name = "cluCluRelationCriteria")
    private org.kuali.student.lum.lu.dto.CluCluRelationCriteria cluCluRelationCriteria;

    public org.kuali.student.lum.lu.dto.CluCluRelationCriteria getCluCluRelationCriteria() {
        return this.cluCluRelationCriteria;
    }

    public void setCluCluRelationCriteria(org.kuali.student.lum.lu.dto.CluCluRelationCriteria newCluCluRelationCriteria)  {
        this.cluCluRelationCriteria = newCluCluRelationCriteria;
    }

}

