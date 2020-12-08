package com.company.domain;

public class Teacher extends People {
    private String tea_id;
    private String tea_name;
    private String password;

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher(){}
    public Teacher(String tea_id, String tea_name, String password) {
        this.tea_id = tea_id;
        this.tea_name = tea_name;
        this.password = password;
    }
}
