/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa;

import java.util.ArrayList;

/**
 *
 * @author isaacmgz
 */
public class Freelancer {

    private String idFreelancer;
    private String name;
    private String emailFreelancer;
    private int costPerHour;
    private String nationality;
    private String englishLevel;

    private AcademicRecord academicRecord;
    private WorkExperience workExperience;
    private Skill skill;

    public ArrayList<Skill> skills = new ArrayList<>();
    public ArrayList<WorkExperience> workExperiences = new ArrayList<>();
    public ArrayList<AcademicRecord> academicRecords = new ArrayList<>();

    public Freelancer() {
    }

    public Freelancer(String idFreelancer, String name, String emailFreelancer, int costPerHour, String nationality, String englishLevel, AcademicRecord academicRecord, WorkExperience workExperience, Skill skill) {
        this.idFreelancer = idFreelancer;
        this.name = name;
        this.emailFreelancer = emailFreelancer;
        this.costPerHour = costPerHour;
        this.nationality = nationality;
        this.englishLevel = englishLevel;
        this.academicRecord = academicRecord;
        this.workExperience = workExperience;
        this.skill = skill;
    }

    public String getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(String idFreelancer) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("""
        \t     --------------------------          
        \t       Freelancer Information
        \t     --------------------------          
                  
        ID -> """).append(idFreelancer)
                .append("\nName -> ").append(name)
                .append("\nEmail address -> ").append(emailFreelancer)
                .append("\nHour rate -> ").append(costPerHour)
                .append("\nNationality -> ").append(nationality)
                .append("\nEnglish level -> ").append(englishLevel)
                .append("\nSkills:\n");

        for (Skill s : skills) {
            sb.append(s);
        }

        sb.append("\nWork Experiences:\n");
        for (WorkExperience w : workExperiences) {
            sb.append(w).append("\n");
        }

        sb.append("\nAcademic Records:\n");
        for (AcademicRecord a : academicRecords) {
            sb.append(a).append("\n");
        }

        return sb.toString();
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }
}
