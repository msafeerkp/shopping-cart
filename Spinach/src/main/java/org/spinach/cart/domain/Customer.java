package org.spinach.cart.domain;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.*;

import org.spinach.cart.repository.CustomerRepository;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Customer database table.
 * 
 * @author Muhammed Safeer
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", columnDefinition = "BINARY(16)", unique = true, nullable = false, updatable = false, length = 16)
	private byte[] customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	@Column(name = "ip_registration_newsletter", length = 15)
	private String ipRegistrationNewsletter;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on", nullable = false)
	private Date modifiedOn;

	@Column(nullable = false, length = 1)
	private String newsletter;

	@Column(name = "special_offer_from_partner", nullable = false, length = 1)
	private String specialOfferFromPartner;

	// bi-directional many-to-one association to Address
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	@Resource
	@Transient
	CustomerRepository customerRepository;

	public Customer() {
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public byte[] getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(byte[] customerId) {
		this.customerId = customerId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getIpRegistrationNewsletter() {
		return this.ipRegistrationNewsletter;
	}

	public void setIpRegistrationNewsletter(String ipRegistrationNewsletter) {
		this.ipRegistrationNewsletter = ipRegistrationNewsletter;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getNewsletter() {
		return this.newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}

	public String getSpecialOfferFromPartner() {
		return this.specialOfferFromPartner;
	}

	public void setSpecialOfferFromPartner(String specialOfferFromPartner) {
		this.specialOfferFromPartner = specialOfferFromPartner;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCustomer(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCustomer(null);

		return address;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Creates a Customer.
	 * 
	 * @param customer
	 */
	public String addCustomer(Customer customer) {
		customer = customerRepository.save(customer);
		return new String(customer.getCustomerId());
	}

}