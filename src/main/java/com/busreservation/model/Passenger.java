package com.busreservation.model;

public class Passenger {
    private String passengerId;
    private String name;
    private int age;
    private String phone;
    private String email;

    public Passenger() {}
    public Passenger(String passengerId, String name, int age, String phone, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}