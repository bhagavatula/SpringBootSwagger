package com.applications.own.dataservices.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the "TKMYORD_USERS" database table.
 * 
 */

@Entity
@Table(name="TKMYORD_USERS")
@NamedQuery(name="TkmyordUser.findAll", query="SELECT t FROM TkmyordUser t")
public class TkmyordUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence-generator")
	@SequenceGenerator(name = "sequence-generator",sequenceName = "tkmyord_user_dtls_sequence", allocationSize = 1)
	@Column(name="id",nullable = false)
	private Integer id;

	private String age;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	@Column(name="delivery_address")
	private String deliveryAddress;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="sex")
	private String sex;

	@Column(name="zipcode")
	private Integer zipcode;

	@Column(name="email")
	private String email;

	public TkmyordUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

}