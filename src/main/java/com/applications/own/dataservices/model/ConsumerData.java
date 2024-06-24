package com.applications.own.dataservices.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * ConsumerData
 */

@Data
public class ConsumerData {


	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("firstname")
	private String firstname = null;

	@JsonProperty("lastname")
	private String lastname = null;

	@JsonProperty("age")
	private String age = null;

	@JsonProperty("sex")
	private String sex = null;

	@JsonProperty("dateofbirth")
	@JsonFormat(pattern = "MM-dd-yyyy")
	private Date dateofbirth = null;

	@JsonProperty("address")
	private String address = null;

	@JsonProperty("zipcode")
	private Integer zipcode = null;

	public ConsumerData id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ConsumerData firstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	/**
	 * Get firstname
	 * 
	 * @return firstname
	 **/

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public ConsumerData lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	/**
	 * Get lastname
	 * 
	 * @return lastname
	 **/

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public ConsumerData age(String age) {
		this.age = age;
		return this;
	}

	/**
	 * Get age
	 * 
	 * @return age
	 **/

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ConsumerData sex(String sex) {
		this.sex = sex;
		return this;
	}

	/**
	 * Get sex
	 * 
	 * @return sex
	 **/

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public ConsumerData dateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
		return this;
	}

	/**
	 * Get dateofbirth
	 * 
	 * @return dateofbirth
	 **/

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public ConsumerData address(String address) {
		this.address = address;
		return this;
	}

	/**
	 * Get address
	 * 
	 * @return address
	 **/

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ConsumerData zipcode(Integer zipcode) {
		this.zipcode = zipcode;
		return this;
	}

	/**
	 * Get zipcode
	 * 
	 * @return zipcode
	 **/

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConsumerData consumerData = (ConsumerData) o;
		return Objects.equals(this.id, consumerData.id)
				&& Objects.equals(this.firstname, consumerData.firstname)
				&& Objects.equals(this.lastname, consumerData.lastname) && Objects.equals(this.age, consumerData.age)
				&& Objects.equals(this.sex, consumerData.sex)
				&& Objects.equals(this.dateofbirth, consumerData.dateofbirth)
				&& Objects.equals(this.address, consumerData.address)
				&& Objects.equals(this.zipcode, consumerData.zipcode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,firstname, lastname, age, sex, dateofbirth, address, zipcode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ConsumerData {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
		sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
		sb.append("    age: ").append(toIndentedString(age)).append("\n");
		sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
		sb.append("    dateofbirth: ").append(toIndentedString(dateofbirth)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
