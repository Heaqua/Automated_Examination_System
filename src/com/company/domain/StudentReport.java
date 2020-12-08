package com.company.domain;

public class StudentReport {
    private short year;
    private boolean sem;
    private String stu_name;
    private String stu_id;
    private String c_id;
    public String[] TITLE = {"Subject code", "Subject name", "Letter grade", "Position(%) in class", "Average " +
            "score in the class", "Highest score in the class", "Professor name", "Professor comments"};
    public String[][] table;

    public StudentReport(short year, boolean sem, String stu_name, String stu_id, String c_id) {
        this.year = year;
        this.sem = sem;
        this.stu_name = stu_name;
        this.stu_id = stu_id;
        this.c_id = c_id;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public boolean isSem() {
        return sem;
    }

    public void setSem(boolean sem) {
        this.sem = sem;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String[] getTITLE() {
        return TITLE;
    }

    public void setTITLE(String[] TITLE) {
        this.TITLE = TITLE;
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }
}
