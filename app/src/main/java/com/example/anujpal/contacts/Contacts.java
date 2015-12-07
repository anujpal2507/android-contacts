package com.example.anujpal.contacts;

/**
 * Created by anujpal on 7/12/15.
 */
public class Contacts {

    int id;
    String name;
    String phone;
    String email;

    public Contacts(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacts(int id, String name, String phone, String email){
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
    }

    public Contacts(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
