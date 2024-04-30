package com.example.doggymapapi.models;

import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long log_id;

    @Column(name = "log_table_name")
    private String log_table_name;

    @Column(name = "log_view")
    private String log_view;

    @Column(name = "log_information")
    private String log_information;


    // Геттеры и сеттеры

    public Logs(){}
    public Logs(Long log_id, String log_table_name, String log_view, String log_information) {
        this.log_id = log_id;
        this.log_table_name = log_table_name;
        this.log_view = log_view;
        this.log_information = log_information;
    }

    public Long getLogID() {
        return log_id;
    }

    public void setLogID(Long log_id) {
        this.log_id = log_id;
    }


    public String getLogTableName() {
        return log_table_name;
    }

    public void setLogTableName(String log_table_name) {
        this.log_table_name = log_table_name;
    }

    public String getLogView() {
        return log_view;
    }

    public void setLogView(String log_view) {
        this.log_view = log_view;
    }


    public String getLogInformation() {
        return log_information;
    }

    public void setLogInformation(String log_information) {
        this.log_information = log_information;
    }

}

