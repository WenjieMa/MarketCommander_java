package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * DistrictProvince entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "district_province", catalog = "marketcommander")
public class DistrictProvince implements java.io.Serializable {

	// Fields

	private Short id;
	private String name;
	private Short parentId;
	private String code;
	private Short order;

	// Constructors

	/** default constructor */
	public DistrictProvince() {
	}

	/** full constructor */
	public DistrictProvince(Short id, String name, Short parentId, String code, Short order) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.code = code;
		this.order = order;
	}

	// Property accessors

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Column(name = "name", length = 270)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_id")

	public Short getParentId() {
		return this.parentId;
	}

	public void setParentId(Short parentId) {
		this.parentId = parentId;
	}

	@Column(name = "code", length = 30)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "order")

	public Short getOrder() {
		return this.order;
	}

	public void setOrder(Short order) {
		this.order = order;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DistrictProvince))
			return false;
		DistrictProvince castOther = (DistrictProvince) other;

		return ((this.getId() == castOther.getId())
				|| (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())))
				&& ((this.getParentId() == castOther.getParentId()) || (this.getParentId() != null
						&& castOther.getParentId() != null && this.getParentId().equals(castOther.getParentId())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null && castOther.getCode() != null
						&& this.getCode().equals(castOther.getCode())))
				&& ((this.getOrder() == castOther.getOrder()) || (this.getOrder() != null
						&& castOther.getOrder() != null && this.getOrder().equals(castOther.getOrder())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getParentId() == null ? 0 : this.getParentId().hashCode());
		result = 37 * result + (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result + (getOrder() == null ? 0 : this.getOrder().hashCode());
		return result;
	}

}