package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EmailVerification database table.
 * @author Muhammed Safeer
 */
@Entity
public class EmailVerification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String emailVerificationId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	private String emailAddress;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ModifiedOn")
	private Date modifiedOn;

	private String verificationHash;

	public EmailVerification() {
	}

	public String getEmailVerificationId() {
		return this.emailVerificationId;
	}

	public void setEmailVerificationId(String emailVerificationId) {
		this.emailVerificationId = emailVerificationId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getVerificationHash() {
		return this.verificationHash;
	}

	public void setVerificationHash(String verificationHash) {
		this.verificationHash = verificationHash;
	}

}