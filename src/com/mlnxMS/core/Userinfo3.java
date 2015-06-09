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
 * Userinfo3 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo3", catalog = "mlnx")
public class Userinfo3 implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private User user;
	private String ueducation;
	private String uschool;

	// Constructors

	/** default constructor */
	public Userinfo3() {
	}

	/** minimal constructor */
	public Userinfo3(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userinfo3(User user, String ueducation, String uschool) {
		this.user = user;
		this.ueducation = ueducation;
		this.uschool = uschool;
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

	@Column(name = "uEducation", length = 50)
	public String getUeducation() {
		return this.ueducation;
	}

	public void setUeducation(String ueducation) {
		this.ueducation = ueducation;
	}

	@Column(name = "uSchool", length = 50)
	public String getUschool() {
		return this.uschool;
	}

	public void setUschool(String uschool) {
		this.uschool = uschool;
	}

}