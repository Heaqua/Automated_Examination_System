package com.company.domain;

import java.math.BigDecimal;

public class TestStats {
    private double[] scores;
    private double average;
    private double median;
    private double max;
    private double min;
    private double sd;
    private String comment;

    public TestStats(double[] scores, double average, double median, double max, double min, double sd, String comment) {
        this.scores = scores;
        this.average = average;
        this.median = median;
        this.max = max;
        this.min = min;
        this.sd = sd;
        this.comment = comment;
    }

    public String getComment(){
        return comment;
    }

    public double[] getScores() {
        return scores;
    }

    public double getAverage() {
        return average;
    }

    public double getMedian() {
        return median;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getSd() {
        return sd;
    }
}
