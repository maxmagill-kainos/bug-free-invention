package com.bug.free.invention.api.Models;

import javax.persistence.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(value = "capability")

public class capability {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(value = "capabilityID")
    @Id int capabilityID;
    @Column(value = "capabilityName")
    private String capabilityName;

    public capability(int capabilityID, String capabilityName) {
        this.capabilityID = capabilityID;
        this.capabilityName = capabilityName;
    }

    public int getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(int capabilityID) {
        this.capabilityID = capabilityID;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }
}