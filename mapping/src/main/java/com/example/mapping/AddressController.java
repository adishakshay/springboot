package com.example.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService as;
    @Autowired
    EmployeeService es;

    @PostMapping("/postadd/{empid}")
    public ResponseEntity<Employee> create(@RequestBody Address a, @PathVariable("empid") int empid) {
        try {
            Employee e = es.getById(empid);
            //e.setId(empid);
            e.setAdd(a);
            //e.setName(null);   The suggestions will automatically arise if dont know the setters name
            
            return new ResponseEntity<>(es.addemployee(e), HttpStatus.CREATED);
        } catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/postadd")
    public ResponseEntity<Address> get(@RequestBody Address a) {

        return new ResponseEntity<>(as.postadd(a), HttpStatus.CREATED);

    }
    @GetMapping("/getadd/{aid}")
    public Address get(@PathVariable int aid)
    {
        return as.getById(aid);
    }

}
