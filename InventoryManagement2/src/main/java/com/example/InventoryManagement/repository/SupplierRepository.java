

package com.example.InventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagement.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
