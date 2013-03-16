package org.spinach.cart.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Person database table.
 * @author Muhammed Safeer
 */
@Entity
@Table(name="Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id", unique=true, nullable=false)
	private int personId;

	@Column(nullable=false, length=45)
	private String active;

	@Temporal(TemporalType.DATE)
	private Date birhtday;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on", nullable=false)
	private Date createdOn;

	@Column(nullable=false, length=128)
	private String email;

	@Column(length=32)
	private String firstname;

	@Column(name="last_password_gen", nullable=false)
	private Timestamp lastPasswordGen;

	@Column(length=32)
	private String lastname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on", nullable=false)
	private Date modifiedOn;

	@Column(nullable=false, length=32)
	private String password;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="person")
	private List<Customer> customers;

	public Person() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getBirhtday() {
		return this.birhtday;
	}

	public void setBirhtday(Date birhtday) {
		this.birhtday = birhtday;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Timestamp getLastPasswordGen() {
		return this.lastPasswordGen;
	}

	public void setLastPasswordGen(Timestamp lastPasswordGen) {
		this.lastPasswordGen = lastPasswordGen;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setPerson(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setPerson(null);

		return customer;
	}

}