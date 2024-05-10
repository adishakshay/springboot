
package com.example.mapping;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String locality, city;

    @OneToOne( cascade = CascadeType.ALL)
   
   @JsonBackReference
    Employee emp;
}