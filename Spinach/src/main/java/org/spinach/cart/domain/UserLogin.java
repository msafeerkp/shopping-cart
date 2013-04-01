package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.UserLoginRepository;

import java.util.List;


/**
 * The persistent class for the UserLogin database table.
 * @author Muhammed Safeer
 */
@Entity
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userLoginId;

	private String currentPassword;

	private String enabled;

	private String hasLoggedIn;

	@Column(name="UserId")
	private String userId;

	@Transient
	@Resource
	public UserLoginRepository userLoginRepository;
	
	//bi-directional many-to-one association to Party
	@OneToOne
	@PrimaryKeyJoinColumn
	private Party party;

	public UserLogin() {
	}

	public String getUserLoginId() {
		return this.userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHasLoggedIn() {
		return this.hasLoggedIn;
	}

	public void setHasLoggedIn(String hasLoggedIn) {
		this.hasLoggedIn = hasLoggedIn;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public UserLoginRepository getUserLoginRepository() {
		return userLoginRepository;
	}

	public void setUserLoginRepository(UserLoginRepository userLoginRepository) {
		this.userLoginRepository = userLoginRepository;
	}
	
}