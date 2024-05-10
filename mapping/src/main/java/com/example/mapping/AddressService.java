package com.example.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService 
{
    @Autowired
    AddressRepo ar;
    public Address postadd(Address a)
    {
        return ar.save(a);
    }
    public Address getById(int aid)
    {
        return ar.findById(aid).orElse(null);
    } 
}
