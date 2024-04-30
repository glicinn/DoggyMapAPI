package com.example.doggymapapi.models;

import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "role")
    private String role;

    // Геттеры и сеттеры



    public User(){}
    public User(Long user_id, String first_name, String last_name, String email, String password, String salt, String role) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public Long getUserID() {
        return user_id;
    }

    public void setUserID(Long user_id) {
        this.user_id = user_id;
    }


    public String getUserFirstName() {
        return first_name;
    }

    public void setUserFirstName(String first_name) {
        this.first_name = first_name;
    }


    public String getUserLastName() {
        return last_name;
    }

    public void setUserLastName(String last_name) {
        this.last_name = last_name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String Role) {
        this.role = Role;
    }

}

