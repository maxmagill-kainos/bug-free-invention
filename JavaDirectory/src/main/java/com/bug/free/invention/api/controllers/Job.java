package com.bug.free.invention.api.controllers;

public class Job {
    private byte id;
    private String name, spec;

    public Job(byte newID, String newName, String newSpec) {
        this.id = newID;
        this.name = newName;
        this.spec = newSpec;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spec='" + spec + '\'' +
                '}';
    }
}
