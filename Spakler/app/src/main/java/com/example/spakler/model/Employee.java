package com.example.spakler.model;

public class Employee {

    private String EmpID;
    private String FirstName;
    private String LastName;
    private String NIC;
    private String Address;
    private String PhoneNo;

    public Employee() {
    }

    public Employee(String empID,  String firstName, String lastName, String NIC, String address, String phoneNo) {
        EmpID = empID;
        FirstName = firstName;
        LastName = lastName;
        this.NIC = NIC;
        Address = address;
        PhoneNo = phoneNo;
    }


    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
}
