package com.company.domain;

public class Student {
    private String name;
    private String stu_id;
    // private Exam[] exams;

    public static boolean login(String name, String stu_id){

        return true;
    }

    public void printSubject(){

    }

    public void printExamTable(){

    }

    public void printClass(){}

    public boolean examAvailable(Exam exam){
        // Get time and judge whether it is later than the start time
        return true;
    }

    public void answerQuestion(Question q){
        // Show the question. Prompt input.
        // Store the answer to sql
    }

    public void takeExam(Exam e){
        // Get the questions from the database
        // A for-loop to answer the question one by one
        // Implement a "back"/"save answer and next question" options after each answer
    }

    public String getTestResult(Exam e){
        return "A";
    }

    public void getAnalysisReport(){

    }



}
