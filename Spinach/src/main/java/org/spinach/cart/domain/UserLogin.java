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
	
	/**
	 * returns the object of the {@link UserLogin} Class. This method returns {@link <code>null</code>},
	 * if the UserLogin details does not exist for the specified userId.
	 * @param userId - login id of the User
	 * @param password - password of the User.
	 * @return object of the {@link UserLogin} Class.
	 * @throws CartException
	 */
	
	public UserLogin isExist(String userId,String password) throws CartException{
		UserLogin userLogin = null;
		try{
			userLogin = userLoginRepository.findByUserIdAndCurrentPassword(userId, password);
		}
		catch(RuntimeException ex){
			logger.error("Exception occured while finding the record for "+userId+".", ex);
			throw new CartException();
		}
		return userLogin;
	}

}