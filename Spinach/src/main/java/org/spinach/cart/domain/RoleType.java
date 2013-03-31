package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RoleType database table.
 * 
 */
@Entity
public class RoleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleTypeId;

	private String roleName;

	//bi-directional many-to-one association to PartyRole
	@OneToMany(mappedBy="roleType")
	private List<PartyRole> partyRoles;

	public RoleType() {
	}

	public int getRoleTypeId() {
		return this.roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<PartyRole> getPartyRoles() {
		return this.partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

	public PartyRole addPartyRole(PartyRole partyRole) {
		getPartyRoles().add(partyRole);
		partyRole.setRoleType(this);

		return partyRole;
	}

	public PartyRole removePartyRole(PartyRole partyRole) {
		getPartyRoles().remove(partyRole);
		partyRole.setRoleType(null);

		return partyRole;
	}

}