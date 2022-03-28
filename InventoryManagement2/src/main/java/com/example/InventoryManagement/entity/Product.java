
package com.example.InventoryManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;
@Data
@Entity
@Table(name="InventoryProductTbl")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private long id;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_category")
	private String productCategory;
	@Column(name="product_price")
	private long productPrice;
	@Column(name="product_desc")
	private String productDesc;

	@ManyToOne
	@JsonBackReference
	@JoinTable(name="product_supplier",joinColumns = { @JoinColumn(name="product_id")},inverseJoinColumns = { @JoinColumn(name="supplier_id")})
	private Supplier supplier;
	
	@ManyToOne
	
    @JoinTable(name="product_customer",joinColumns = { @JoinColumn(name="product_id")},inverseJoinColumns = { @JoinColumn(name="customer_id")})
    
    private Customer customer;
	
}
