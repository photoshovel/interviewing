package com.consultcalhoun.interviewing.rewards;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 20, name = "first_name")
    private String firstName;
    
    @Column(nullable = false, length = 20, name = "last_name")
    private String lastName;
    
    @Column(nullable = false, length = 5, name = "zip_code")
    private String zipCode;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.zipCode);
    }
}
