package com.example.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService es;
    @Autowired
    AddressService as;

    @PostMapping("/postemp")
    public ResponseEntity<Employee> postemp(@RequestBody Employee e) {
        return new ResponseEntity<>(es.addemployee(e), HttpStatus.CREATED);
    }

    @PostMapping("/postemp/{aid}")
    public ResponseEntity<Address> create(@RequestBody Employee e, @PathVariable int aid) {
        try {
            Address a = as.getById(aid);
            // e.setId(empid);
            a.setEmp(e);
            // e.setName(null); The suggestions will automatically arise if dont know the
            // setters name
            return new ResponseEntity<>(as.postadd(a), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getemp/{eid}")
    public Employee get(@PathVariable int eid) 
    {
        return es.getById(eid);
    }
}
