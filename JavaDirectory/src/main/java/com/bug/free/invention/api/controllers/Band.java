package com.bug.free.invention.api.controllers;

public class Band {

    private int id;
    private String name;
    private int level;
    private String training;
    private String competencies;
    private String responsibilities;

    public Band(int id, String name, int level, String training, String competencies, String responsibilities) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.training = training;
        this.competencies = competencies;
        this.responsibilities = responsibilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", training='" + training + '\'' +
                ", competencies='" + competencies + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                '}';
    }
}
