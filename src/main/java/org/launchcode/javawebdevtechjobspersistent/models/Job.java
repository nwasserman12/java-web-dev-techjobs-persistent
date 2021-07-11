package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity{

    @ManyToOne
    private Employer employer;

    @ManyToOne
    private Skill skills;

    public Job() {
    }

    public Job(Employer employer, Skill skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }
}
