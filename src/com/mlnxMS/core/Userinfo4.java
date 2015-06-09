package com.mlnxMS.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Userinfo4 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo4", catalog = "mlnx")
public class Userinfo4 implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private User user;
	private String ucompany;
	private String uoccupation;
	private String uposition;
	private String urevenue;

	// Constructors

	/** default constructor */
	public Userinfo4() {
	}

	/** minimal constructor */
	public Userinfo4(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userinfo4(User user, String ucompany, String uoccupation,
			String uposition, String urevenue) {
		this.user = user;
		this.ucompany = ucompany;
		this.uoccupation = uoccupation;
		this.uposition = uposition;
		this.urevenue = urevenue;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "infoId", unique = true, nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "uCompany", length = 50)
	public String getUcompany() {
		return this.ucompany;
	}

	public void setUcompany(String ucompany) {
		this.ucompany = ucompany;
	}

	@Column(name = "uOccupation", length = 50)
	public String getUoccupation() {
		return this.uoccupation;
	}

	public void setUoccupation(String uoccupation) {
		this.uoccupation = uoccupation;
	}

	@Column(name = "uPosition", length = 50)
	public String getUposition() {
		return this.uposition;
	}

	public void setUposition(String uposition) {
		this.uposition = uposition;
	}

	@Column(name = "uRevenue", length = 50)
	public String getUrevenue() {
		return this.urevenue;
	}

	public void setUrevenue(String urevenue) {
		this.urevenue = urevenue;
	}

}