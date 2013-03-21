package org.spinach.cart.dto;

/**
 * DTO for Account Creation Request
 * @author Muhammed Safeer
 *
 */
public class CustomerAccountCreationDTO extends BaseDTO {
	private String emailID;
	private String password;
	private String confirmPassword;
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
