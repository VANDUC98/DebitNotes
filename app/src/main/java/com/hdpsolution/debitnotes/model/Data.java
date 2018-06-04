package com.hdpsolution.debitnotes.model;

import java.io.Serializable;

public class Data implements Serializable{
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String date;
    private String number;
    private String percent;
    private String note;
    private int type;

    public Data() {
    }

    public Data(String name, String phoneNumber, String address, String date, String number, String percent, String note, int type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.date = date;
        this.number = number;
        this.percent = percent;
        this.note = note;
        this.type = type;
    }

    public Data(int id, String name, String phoneNumber, String address, String date, String number, String percent, String note, int type) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.date = date;
        this.number = number;
        this.percent = percent;
        this.note = note;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
