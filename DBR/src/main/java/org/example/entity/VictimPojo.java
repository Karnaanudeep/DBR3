package org.example.entity;

import java.util.Objects;

public class VictimPojo {
    private String name;
    private int age;
    private  String dogBreed;
    private boolean dogVaccinatedStatus;
    private String address;

    public VictimPojo(){}

    public VictimPojo(String name, int age, String dogBreed, boolean dogVaccinatedStatus, String address) {
        this.name = name;
        this.age = age;
        this.dogBreed = dogBreed;
        this.dogVaccinatedStatus = dogVaccinatedStatus;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public boolean getDogVaccinatedStatus() {
        return dogVaccinatedStatus;
    }

    public void setDogVaccinatedStatus(boolean dogVaccinatedStatus) {
        this.dogVaccinatedStatus = dogVaccinatedStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VictimPojo that = (VictimPojo) o;
        return age == that.age && dogVaccinatedStatus == that.dogVaccinatedStatus && Objects.equals(name, that.name) && Objects.equals(dogBreed, that.dogBreed) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dogBreed, dogVaccinatedStatus, address);
    }

    @Override
    public String toString() {
        return "VictimPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dogBreed='" + dogBreed + '\'' +
                ", dogVaccinatedStatus=" + dogVaccinatedStatus +
                ", address='" + address + '\'' +
                '}';
    }
}
