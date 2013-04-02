package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UserLogin database table.
 * 
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

	//bi-directional one-to-one association to Party
	@OneToOne
	@JoinColumn(name="partyId",referencedColumnName = "partyId")
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
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}