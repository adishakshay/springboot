package com.example.accounting;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account
{
    @Id
    int accountId;
    String name, email, 
    contact, organizationName, city, state, 
    country, postalCode, password, confirmPassword;

    public Account()
    {

    }

    public Account(int accountId, String name, String email, String contact,
            String organizationName, String city, String state, String country, String postalCode, String password,
            String confirmPassword) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.organizationName = organizationName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPasswork(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
}
