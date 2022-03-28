package com.example.InventoryManagement.entity;


import java.util.List;

//import java.util.List;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="InventoryCustomerTbl")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;	
	@Column(name="contact_No")
	private long contactNo;
	@Column(name="address")
	private String address;
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="customer")
	List<Product> product;
	
    @OneToMany(mappedBy="customer")
    List<Invoice> invoice;
	
	
	
	
}