package com.company.domain;

public class Teacher {
    private String name;
    private String tea_id;

    public boolean login(String name, String stu_id){
        return true;
    }

    public boolean instructor(Class e){
        return true;
    }

    public boolean eligibleToSetExam(Subject s, Class c){
        return true;
    }

    public void setExam(Subject s, Class c, String date,
                        String start_time, String duration){
        // check eligible or not
        // Call exam constructor
    }
    public void setQuestion(Exam e, int questionNumber, boolean compulsory, String type, double score){
        // Complete the parameters
    }
    public void gradeQuestion(Question q){
        // question type other than T/F or MCQ
    }
    public void gradeExam(Exam e){}

    public void printInformation(){
        // Instructor?
        // Subject ? Class?
    }

    public String getTestResult(Exam e, Student s){
        return "A";
    }

    public void getAnalysisReport(Student s){

    }
}
