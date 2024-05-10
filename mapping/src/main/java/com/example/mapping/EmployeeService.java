package com.example.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService 
{
    @Autowired
    EmployeeRepo er;
    public Employee addemployee(Employee e)
    {
        return er.save(e);
    }     
    public Employee getById(int empid)
    {
        return er.findById(empid).orElse(null);
    }
}
