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
 * Userinfo5 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo5", catalog = "mlnx")
public class Userinfo5 implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private User user;
	private String uaddress;
	private String uzipcode;
	private String ubio;
	private String uinterest;

	// Constructors

	/** default constructor */
	public Userinfo5() {
	}

	/** minimal constructor */
	public Userinfo5(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userinfo5(User user, String uaddress, String uzipcode, String ubio,
			String uinterest) {
		this.user = user;
		this.uaddress = uaddress;
		this.uzipcode = uzipcode;
		this.ubio = ubio;
		this.uinterest = uinterest;
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

	@Column(name = "uAddress", length = 50)
	public String getUaddress() {
		return this.uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	@Column(name = "uZipcode", length = 50)
	public String getUzipcode() {
		return this.uzipcode;
	}

	public void setUzipcode(String uzipcode) {
		this.uzipcode = uzipcode;
	}

	@Column(name = "uBio", length = 500)
	public String getUbio() {
		return this.ubio;
	}

	public void setUbio(String ubio) {
		this.ubio = ubio;
	}

	@Column(name = "uInterest", length = 500)
	public String getUinterest() {
		return this.uinterest;
	}

	public void setUinterest(String uinterest) {
		this.uinterest = uinterest;
	}

}