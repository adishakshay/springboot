package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// import com.example.project.model.*;
// import com.example.project.repository.*;

@Service
public class ProductService {
   
    @Autowired
    ProductRepo pr;

    //post
    public Product create(Product p)
    {
        return pr.save(p);
    }

    //getbyid
    public Product getById(int productId)
    {
        return pr.findById(productId).orElse(null);
    }

    //getAll
    public List<Product> getAll()
    {
        return pr.findAll();
    }
    
    //put
    public boolean updateDetails(int productId,Product p)
    {
        if(pr.findById(productId)==null)
        {
            return false;
        }
        try
        {
            pr.save(p);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteEmployee(int employeeId)
    {
        if(this.getById(employeeId) == null)
        {
            return false;
        }
        pr.deleteById(employeeId);
        return true;
    }

    public List<Product> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}