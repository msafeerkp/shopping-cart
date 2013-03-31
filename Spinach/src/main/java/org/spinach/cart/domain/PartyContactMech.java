package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PartyContactMech database table.
 * 
 */
@Entity
public class PartyContactMech implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String partyContactMechId;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@JoinColumn(name="partyId")
	private Party party;

	public PartyContactMech() {
	}

	public String getPartyContactMechId() {
		return this.partyContactMechId;
	}

	public void setPartyContactMechId(String partyContactMechId) {
		this.partyContactMechId = partyContactMechId;
	}

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}