package com.example.Product.Management.Model;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String email;
    private double rollNo;

    private String gender;

    public Student(String name, String email, int rollNo,String gender) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
        this.gender = gender;
    }

    public Student() {
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public  void displayName(){
        System.out.println("My name is "+this.name);
    }


}
