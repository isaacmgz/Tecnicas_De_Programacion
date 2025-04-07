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
    
    private int idFreelancer;
    private String name;
    private String emailFreelancer;
    private int costPerHour;
    private String nationality;
    
    private AcademicRecord academicRecord;
    private WorkExperience workExperience;
    private Skill skill;

    public Freelancer() {
    }

    public Freelancer(int idFreelancer, String name, String emailFreelancer, int costPerHour, String nationality, AcademicRecord academicRecord, WorkExperience workExperience, Skill skill) {
        this.idFreelancer = idFreelancer;
        this.name = name;
        this.emailFreelancer = emailFreelancer;
        this.costPerHour = costPerHour;
        this.nationality = nationality;
        this.academicRecord = academicRecord;
        this.workExperience = workExperience;
        this.skill = skill;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailFreelancer() {
        return emailFreelancer;
    }

    public void setEmailFreelancer(String emailFreelancer) {
        this.emailFreelancer = emailFreelancer;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
