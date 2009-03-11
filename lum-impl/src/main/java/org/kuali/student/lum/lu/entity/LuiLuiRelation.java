package org.kuali.student.lum.lu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.kuali.student.common.util.UUIDHelper;
import org.kuali.student.core.entity.AttributeOwner;
import org.kuali.student.core.entity.MetaEntity;

@Entity
@Table(name = "KSLU_LUILUI_RELTN")
@NamedQueries( {
	@NamedQuery(name = "LuiLuiRelation.getLuiLuiRelationsByLuiId", query = "SELECT llr FROM LuiLuiRelation llr WHERE llr.lui.id = :luiId"),
	@NamedQuery(name = "LuiLuiRelation.getLuiIdsByRelationType", query = "SELECT rel.lui.id FROM LuiLuiRelation rel WHERE rel.relatedLui.id = :luiId AND luLuRelationType.id = :luLuRelationTypeId"),
	@NamedQuery(name = "LuiLuiRelation.getLuisByRelationType", query = "SELECT rel.lui FROM LuiLuiRelation rel WHERE rel.relatedLui.id = :luiId AND rel.luLuRelationType.id = :luLuRelationTypeId"),
	@NamedQuery(name = "LuiLuiRelation.getRelatedLuiIdsByLuiId", query = "SELECT rel.relatedLui.id FROM LuiLuiRelation rel WHERE lui.id = :luiId AND luLuRelationType.id = :luLuRelationTypeId"),
	@NamedQuery(name = "LuiLuiRelation.getRelatedLuisByLuiId", query = "SELECT rel.relatedLui FROM LuiLuiRelation rel WHERE rel.lui.id = :luiId AND rel.luLuRelationType.id = :luLuRelationTypeId")
})
public class LuiLuiRelation extends MetaEntity implements
		AttributeOwner<LuiLuiRelationAttribute> {
	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "LUI_ID")
	private Lui lui;

	@ManyToOne
	@JoinColumn(name = "RELATED_LUI_ID")
	private Lui relatedLui;

	@ManyToOne
	@JoinColumn(name = "LULU_RELTN_TYPE_ID")
	private LuLuRelationType luLuRelationType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_DT")
	private Date effectiveDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIR_DT")
	private Date expirationDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "OWNER")
	private List<LuiLuiRelationAttribute> attributes;

	@Column(name = "ST")
	private String state;

	@Override
	public final void onPrePersist() {
		this.id = UUIDHelper.genStringUUID(this.id);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Lui getLui() {
		return lui;
	}

	public void setLui(Lui lui) {
		this.lui = lui;
	}

	public Lui getRelatedLui() {
		return relatedLui;
	}

	public void setRelatedLui(Lui relatedLui) {
		this.relatedLui = relatedLui;
	}

	public LuLuRelationType getLuLuRelationType() {
		return luLuRelationType;
	}

	public void setLuLuRelationType(LuLuRelationType luLuRelationType) {
		this.luLuRelationType = luLuRelationType;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<LuiLuiRelationAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<LuiLuiRelationAttribute>();
		}
		return attributes;
	}

	public void setAttributes(List<LuiLuiRelationAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
