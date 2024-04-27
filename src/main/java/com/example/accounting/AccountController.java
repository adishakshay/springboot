package com.example.accounting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    @Autowired
    AccountService as;

    @PostMapping("/account")
    public ResponseEntity<Account> adddata(@RequestBody Account p)
    {
        Account obj=as.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<Account> get(@PathVariable("accountId") int accountId )
    {
        try 
        {
        Account p = as.getById(accountId);
        return new ResponseEntity<>(p,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
    }

    @GetMapping("/accountt")
    public ResponseEntity<List<Account>> getAll()
    {
        try 
        {
        List<Account> p = as.getAll();
        return new ResponseEntity<>(p,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sort/{field}")
    public ResponseEntity<List<Account>> getbysort(@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(as.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/account/{accountId}")
    public ResponseEntity<Account> putMethod(@PathVariable("accountId") int accountId,@RequestBody Account ad)
    {
        if(as.updateDetails(accountId,ad) == true)
        {
            return new ResponseEntity<>(ad,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<Boolean> delete(@PathVariable("accountId") int accountId)
    {
        if(as.deleteEmployee(accountId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
