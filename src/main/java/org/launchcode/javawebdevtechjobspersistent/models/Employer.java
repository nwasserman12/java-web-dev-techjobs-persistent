package org.launchcode.javawebdevtechjobspersistent.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employer extends AbstractEntity {

    @NotNull
    @Size(max = 50, message = "Must not exceed 50 characters")
    private String location;

    public Employer(String location){
        this.location = location;
    }

    public Employer(){}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
