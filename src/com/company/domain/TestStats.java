package com.company.domain;

public class TestStats {
    private double[] scores;
    private double average;
    private double median;
    private double max;
    private double min;
    private double sd;

    public TestStats(double[] scores, double average, double median, double max, double min, double sd) {
        this.scores = scores;
        this.average = average;
        this.median = median;
        this.max = max;
        this.min = min;
        this.sd = sd;
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
