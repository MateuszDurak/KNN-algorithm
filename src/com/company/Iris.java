package com.company;

public class Iris implements  Comparable<Iris>{
    private double distance;
    private String testName;
    private String trainingName;

    public Iris(double distance, String testName, String trainingName) {
        this.distance = distance;
        this.testName = testName;
        this.trainingName = trainingName;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "distance=" + distance +
                ", testName='" + testName + '\'' +
                ", trainingName='" + trainingName + '\'' +
                '}';
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    @Override
    public int compareTo(Iris iris) {
        if (getDistance() == 0.0 || iris.getDistance() == 0.0) {
            return 0;
        }
        return Double.compare(getDistance(),iris.getDistance());
    }


}
