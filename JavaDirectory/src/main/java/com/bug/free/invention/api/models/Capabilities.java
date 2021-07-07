package com.bug.free.invention.api.models;

public class Capabilities {

    private short Capability_ID;
    private String Capability_Name;

    public Capabilities() {
    }

    public Capabilities(short capability_ID, String capability_Name) {
        Capability_ID = capability_ID;
        Capability_Name = capability_Name;
    }

    public short getCapability_ID() {
        return Capability_ID;
    }

    public void setCapability_ID(short capability_ID) {
        Capability_ID = capability_ID;
    }

    public String getCapability_Name() {
        return Capability_Name;
    }

    public void setCapability_Name(String capability_Name) {
        Capability_Name = capability_Name;
    }
}
