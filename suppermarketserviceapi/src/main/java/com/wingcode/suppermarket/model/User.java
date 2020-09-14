package com.wingcode.suppermarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class of user.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Entity
@Table(name = "user")
//@JsonRootName(value = "User")
public class User extends AuditModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** user_Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false, updatable = false)
	private Integer userId;

	/** name. */
	@Column(name = "name")
	private String name;

	/** email. */
	@Column(name = "email")
	private String email;

	/** user_Role. */
	@Column(name = "user_Role")
	private String userRole;

	/** password. */
	@Column(name = "password")
	private String password;

	/**
	 * Set the user_Id.
	 * 
	 * @param userId
	 *            user_Id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Get the user_Id.
	 * 
	 * @return user_Id
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * Set the name.
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the email.
	 * 
	 * @param email
	 *            email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the email.
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set the user_Role.
	 * 
	 * @param userRole
	 *            user_Role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Get the user_Role.
	 * 
	 * @return user_Role
	 */
	public String getUserRole() {
		return this.userRole;
	}

	/**
	 * Set the password.
	 * 
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the password.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
