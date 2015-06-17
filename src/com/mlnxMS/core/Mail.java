package com.mlnxMS.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mail", catalog = "mlnx")
public class Mail implements java.io.Serializable {

	// Fields

	private Integer mid;
	private User userBySendUid;
	private User userByReceiveUid;
	private String mailTitle;
	private String mailContent;

	// Constructors

	/** default constructor */
	public Mail() {
	}

	/** full constructor */
	public Mail(Integer mid, User userBySendUid, User userByReceiveUid,
			String mailTitle, String mailContent) {
		this.mid = mid;
		this.userBySendUid = userBySendUid;
		this.userByReceiveUid = userByReceiveUid;
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
	}

	// Property accessors
	@Id
	@Column(name = "mId", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sendUid", nullable = false)
	public User getUserBySendUid() {
		return this.userBySendUid;
	}

	public void setUserBySendUid(User userBySendUid) {
		this.userBySendUid = userBySendUid;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiveUid", nullable = false)
	public User getUserByReceiveUid() {
		return this.userByReceiveUid;
	}

	public void setUserByReceiveUid(User userByReceiveUid) {
		this.userByReceiveUid = userByReceiveUid;
	}

	@Column(name = "mailTitle", nullable = false, length = 50)
	public String getMailTitle() {
		return this.mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	@Column(name = "mailContent", nullable = false, length = 3000)
	public String getMailContent() {
		return this.mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

}