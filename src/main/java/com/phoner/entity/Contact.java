package com.phoner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="Contact")
@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="contact_id")
	private Long id;
	
	@Column(name="contact_name")
	private String name;
	
	@Column(name="contact_number")
	private String contactNo;
	
	@Column(name="contact_email")
	private String email;
	
	@Column(name="contact_isActive")
	private boolean isActive;
}
