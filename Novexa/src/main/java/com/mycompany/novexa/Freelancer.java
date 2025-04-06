/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa;

/**
 *
 * @author isaacmgz
 */
public class Freelancer {
    
    private String name;
    private int idFreelancer;
    private int costPerHour;
    
    private AcademicRecord academicRecord;
    private WorkExperience workExperience;
    private Skill skill;

    public Freelancer(String name, int idFreelancer, int costPerHour, AcademicRecord academicRecord, WorkExperience workExperience, Skill skill) {
        this.name = name;
        this.idFreelancer = idFreelancer;
        this.costPerHour = costPerHour;
        this.academicRecord = academicRecord;
        this.workExperience = workExperience;
        this.skill = skill;
    }

    public Freelancer() {
    }

    @Override
    public String toString() {
        return "Freelancer{" + "name=" + name + ", idFreelancer=" + idFreelancer + ", costPerHour=" + costPerHour + ", academicRecord=" + academicRecord + ", workExperience=" + workExperience + ", skill=" + skill + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public AcademicRecord getAcademicRecord() {
        return academicRecord;
    }

    public void setAcademicRecord(AcademicRecord academicRecord) {
        this.academicRecord = academicRecord;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
