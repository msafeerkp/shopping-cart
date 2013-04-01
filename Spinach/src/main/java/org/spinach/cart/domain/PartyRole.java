package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PartyRole database table.
 * @author Muhammed Safeer
 */
@Entity
public class PartyRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String partyRoleId;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@JoinColumn(name="partyId")
	private Party party;

	//bi-directional many-to-one association to RoleType
	@ManyToOne
	@JoinColumn(name="roleTypeId")
	private RoleType roleType;

	public PartyRole() {
	}

	public String getPartyRoleId() {
		return this.partyRoleId;
	}

	public void setPartyRoleId(String partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

}