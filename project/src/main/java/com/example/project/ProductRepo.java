package com.example.project;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.project.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
   
}