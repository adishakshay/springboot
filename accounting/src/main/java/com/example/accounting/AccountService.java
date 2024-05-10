package com.example.accounting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
   
    @Autowired
    AccountRepo pr;

    //post
    public Account create(Account p)
    {
        return pr.save(p);
    }

    //getbyid
    public Account getById(int accountId)
    {
        return pr.findById(accountId).orElse(null);
    }

    //getAll
    public List<Account> getAll()
    {
        return pr.findAll();
    }
    
    //put
    public boolean updateDetails(int accountId, Account p)
    {
        if(pr.findById(accountId)==null)
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

    public List<Account> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}