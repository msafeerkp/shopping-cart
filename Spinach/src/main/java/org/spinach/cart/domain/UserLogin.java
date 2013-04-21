package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.apache.log4j.Logger;
import org.spinach.cart.exception.CartException;
import org.spinach.cart.repository.UserLoginRepository;
import org.springframework.stereotype.Component;


/**
 * The persistent class for the UserLogin database table.
 * 
 */
@Entity
@Component("userLogin")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userLoginId;

	private String currentPassword;

	private String enabled;

	@Column(name="UserId")
	private String userId;

	//bi-directional one-to-one association to Party
	@OneToOne
	@JoinColumn(name="partyId",referencedColumnName = "partyId")
	private Party party;
	
	@Transient
	@Resource
	private UserLoginRepository userLoginRepository;

	@Transient
	Logger logger = Logger.getLogger(UserLogin.class);
	
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

	public UserLoginRepository getUserLoginRepository() {
		return userLoginRepository;
	}

	public void setUserLoginRepository(UserLoginRepository userLoginRepository) {
		this.userLoginRepository = userLoginRepository;
	}
	
/*	public void addUserLogin(){
		userLoginRepository.save(this);
	}*/
	
	public UserLogin isExistAndActive(String userId,String enabled) throws CartException{
		UserLogin userLogin = null;
		try{
			userLogin = userLoginRepository.findByUserIdAndEnabled(userId, enabled);
		}
		catch(RuntimeException ex){
			logger.error("Exception occured while finding the record for "+userId+".", ex);
			throw new CartException();
		}
		return userLogin;
	}

}