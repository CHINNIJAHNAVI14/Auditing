package com.spring.user.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="users")
public class User 
{
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Created_Date",nullable=false,updatable = false)
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column(name="Created_By",length = 30, nullable = false)
	@CreatedBy
	private String createdBy;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id",length=500)
	private Long id;
	

	@Column(name="Name" ,nullable=false,length=500)
	private String name;
	

	@Column(name="Email",nullable=false, length=500)
	private String email;
	
	@Column(name="Degree",nullable=true, length=500)
	private String degree;
	
	@Column(name="age",nullable = false,length=500)
	private Long age;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastModified_date",nullable=false)
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	
	
	private String country;
	private String district;
	
	@PrePersist
	private void prePersist() 
	 {
	        createdDate = LocalDateTime.now();
	        lastModifiedDate = LocalDateTime.now();
	 }
	public User()
	{
		
	}
	
	
	
	public User(LocalDateTime createdDate, String createdBy, Long id, String name, String email, String degree,
			Long age, LocalDateTime lastModifiedDate, String country, String district) {
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.id = id;
		this.name = name;
		this.email = email;
		this.degree = degree;
		this.age = age;
		this.lastModifiedDate = lastModifiedDate;
		this.country = country;
		this.district = district;
	}
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDegree() {
		return degree;
	}



	public void setDegree(String degree) {
		this.degree = degree;
	}



	public LocalDateTime getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}



	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_Id", length = 10, nullable = false)
	private Integer id;

	@NotNull(message = "Customer name cannot be blank")
	@Pattern(regexp = "^[A-Za-z][A-Za-z]{2,29}$", message = "Name must be of 3 to 30 length with only alphabets")
	@Column(name = "C_Name", length = 30, nullable = false)
	private String name;

	@NotBlank(message = "Email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email should be valid")
	@Column(name = "C_Email", length = 40, nullable = false)
	private String email;

	@Positive
	@Digits(integer = 10, fraction = 0, message = "The Phone should be a number with integer part of up to 10 digits!")
	@Column(name = "C_Phone", length = 30, nullable = false)
	private long phone;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
 * */

}




























