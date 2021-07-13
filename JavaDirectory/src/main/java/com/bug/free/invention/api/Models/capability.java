package com.bug.free.invention.api.Models;

import javax.persistence.*;

@Entity
@Table(name = "capability")

public class capability {
    @ManyToOne
    @Id int capabilityID;
    private String capabilityName;

}
