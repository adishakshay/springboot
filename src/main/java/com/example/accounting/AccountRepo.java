package com.example.accounting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import com.example.project.model.Product;
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>
{
   
}