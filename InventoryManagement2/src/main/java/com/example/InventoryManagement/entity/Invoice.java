

package com.example.InventoryManagement.entity;






//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name="InventoryInvoiceTbl")
public class Invoice {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="total_amount")
	private String totalAmount;
	@Column(name="customerid")
	private String CustomerId;
	@Column(name="date")
	private String date;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinTable(name="invoice_customer",joinColumns = { @JoinColumn(name="invoice_id")},inverseJoinColumns = { @JoinColumn(name="customer_id")})
	private Customer customer;
}
