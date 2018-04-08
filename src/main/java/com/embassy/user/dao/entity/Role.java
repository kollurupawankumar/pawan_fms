package com.embassy.user.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "auth_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	private String roleName;
	private int isDeleted;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
	private int createdUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTimestamp;
	private int lastModifiedUser;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public int getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}

	public Date getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(Date lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public int getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(int lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

}
