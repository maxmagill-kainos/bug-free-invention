package com.bug.free.invention.api.Models;
import java.util.UUID;
public class Employee {
    int id;
    String name ;
    String address ;
    String UUID;
    boolean isAdmin;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public Employee(int id, String name,String UUID,boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.UUID = UUID;
        this.isAdmin = isAdmin;
    }

    public String getUUID() {
        return UUID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", address='" + this.address + '\'' +
                '}';
    }
}
