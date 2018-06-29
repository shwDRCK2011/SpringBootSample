package com.bugReport.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bug_user")
public class BugUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2667613986574665732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "bug_user_id")
	private Long bugUserId;

	@ManyToOne
	@JoinColumn(name = "bug_id", referencedColumnName = "bug_id")
	private Bug bugId;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;

	public Bug getBugId() {
		return bugId;
	}

	public void setBugId(Bug bugId) {
		this.bugId = bugId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Long getBugUserId() {
		return bugUserId;
	}

	public void setBugUserId(Long bugUserId) {
		this.bugUserId = bugUserId;
	}

}
