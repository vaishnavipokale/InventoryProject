
package com.example.InventoryManagement.entity;


import java.util.List;

//import java.util.List;

//import javax.persistence.CascadeType;
//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="InventorySupplierTbl")
public class Supplier {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@Column(name="supp_id")
	//@Column
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;	
	@Column(name="contact_No")
	private long contactNo;
	
	@OneToMany(mappedBy="supplier")//cascade = CascadeType.ALL)
	 List<Product> product;
	
}
