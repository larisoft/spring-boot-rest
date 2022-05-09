package com.example.springbackend.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="employees")
public class Employee {


    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Id
    @Column(name="Id")
    private long id;

    @Column(name="fist_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Employee(){

    }
    public Employee(String fname, String lname, String email){
       this.firstName = fname;
       this.lastName = lname;
       this.email = email;
    }

    public long getId(){return id;}

    public void setId(long id ){this.id = id;}

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getEmail(){

        return email;
    }
    public void setFirstName(String fname){
        this.firstName = fname;
    }

    public void setLastName(String lname){
        this.lastName = lname;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
