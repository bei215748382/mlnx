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
 * Userinfo2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo2", catalog = "mlnx")
public class Userinfo2 implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private User user;
	private String umobile;
	private String uqq;
	private String uemail;
	private String utelephone;
	private String umsn;
	private String utaobao;

	// Constructors

	/** default constructor */
	public Userinfo2() {
	}

	/** minimal constructor */
	public Userinfo2(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userinfo2(User user, String umobile, String uqq, String uemail,
			String utelephone, String umsn, String utaobao) {
		this.user = user;
		this.umobile = umobile;
		this.uqq = uqq;
		this.uemail = uemail;
		this.utelephone = utelephone;
		this.umsn = umsn;
		this.utaobao = utaobao;
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

	@Column(name = "uMobile", length = 50)
	public String getUmobile() {
		return this.umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	@Column(name = "uQQ", length = 50)
	public String getUqq() {
		return this.uqq;
	}

	public void setUqq(String uqq) {
		this.uqq = uqq;
	}

	@Column(name = "uEmail", length = 50)
	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	@Column(name = "uTelephone", length = 50)
	public String getUtelephone() {
		return this.utelephone;
	}

	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}

	@Column(name = "uMsn", length = 50)
	public String getUmsn() {
		return this.umsn;
	}

	public void setUmsn(String umsn) {
		this.umsn = umsn;
	}

	@Column(name = "uTaobao", length = 50)
	public String getUtaobao() {
		return this.utaobao;
	}

	public void setUtaobao(String utaobao) {
		this.utaobao = utaobao;
	}

}