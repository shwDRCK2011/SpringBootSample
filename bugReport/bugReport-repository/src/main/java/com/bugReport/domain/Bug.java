
package com.bugReport.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author User
 */
@Entity
@Table(name = "bugs")
public class Bug implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "bug_id")
	private Long bugId;
	@Column(name = "bug_name")
	private String bugName;
	@Column(name = "bug_start_date")
	private Date bugStartDate;
	@Column(name = "bug_expected_to_end_date")
	private Date bugExpectedToEndDate;

	@ManyToOne
	@JoinColumn(name = "bug_status_id")
	private BugStatus bugStatus;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToMany(mappedBy = "bugId")
	private List<BugUser> bugUsers;

	public Long getBugId() {
		return bugId;
	}

	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public BugStatus getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(BugStatus bugStatus) {
		this.bugStatus = bugStatus;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getBugStartDate() {
		return bugStartDate;
	}

	public void setBugStartDate(Date bugStartDate) {
		this.bugStartDate = bugStartDate;
	}

	public Date getBugExpectedToEndDate() {
		return bugExpectedToEndDate;
	}

	public void setBugExpectedToEndDate(Date bugExpectedToEndDate) {
		this.bugExpectedToEndDate = bugExpectedToEndDate;
	}

	public List<BugUser> getBugUsers() {
		return bugUsers;
	}

	public void setBugUsers(List<BugUser> bugUsers) {
		this.bugUsers = bugUsers;
	}

}
