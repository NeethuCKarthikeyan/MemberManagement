package com.ust.ticl.management.model;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="member")
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	private String password;

	@Column(name = "mob_num")
	private Integer mobNum;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "pin_num")
	private int pinNum;
	
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	
}
