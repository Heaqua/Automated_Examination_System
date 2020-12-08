package com.company.domain;

public class Teacher extends People {
    private String tea_id;
    private String tea_name;
    private String password;

    public String getTea_id() {
        return tea_id;
    }


    public String getTea_name() {
        return tea_name;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public Teacher(String tea_id, String tea_name, String password) {
        super(tea_name, tea_id, password);
    }
}
