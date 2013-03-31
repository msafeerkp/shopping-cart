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

	private byte[] currentPassword;

	private String enabled;

	private String hasLoggedIn;

	@Column(name="UserId")
	private String userId;

	//bi-directional many-to-one association to Party
	@OneToMany(mappedBy="userLogin")
	private List<Party> parties;

	public UserLogin() {
	}

	public String getUserLoginId() {
		return this.userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public byte[] getCurrentPassword() {
		return this.currentPassword;
	}

	public void setCurrentPassword(byte[] currentPassword) {
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

	public List<Party> getParties() {
		return this.parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public Party addParty(Party party) {
		getParties().add(party);
		party.setUserLogin(this);

		return party;
	}

	public Party removeParty(Party party) {
		getParties().remove(party);
		party.setUserLogin(null);

		return party;
	}

}