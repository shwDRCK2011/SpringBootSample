package com.bugReport.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bug_status")
public class BugStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "bug_status_id")
	private Long bugStatusId;
	@Column(name = "bug_status")
	private String bugStatus;

	@OneToMany(mappedBy = "bugStatus")
	private List<Bug> bug;

	public Long getBugStatusId() {
		return bugStatusId;
	}

	public void setBugStatusId(Long bugStatusId) {
		this.bugStatusId = bugStatusId;
	}

	public String getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}

	public List<Bug> getBug() {
		return bug;
	}

	public void setBug(List<Bug> bug) {
		this.bug = bug;
	}

	
}
