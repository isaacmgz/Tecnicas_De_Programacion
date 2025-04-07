/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa;

/**
 *
 * @author isaacmgz
 */
public class WorkExperience {
    
    private String companyName;
    private String position;
    private String rolSpecification;
    private int duration; 

    public WorkExperience(String companyName, String position, String rolSpecification,int duration) {
        this.companyName = companyName;
        this.position = position;
        this.rolSpecification = rolSpecification;
        this.duration = duration;
    }

    public WorkExperience() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRolSpecification() {
        return rolSpecification;
    }

    public void setRolSpecification(String rolSpecification) {
        this.rolSpecification = rolSpecification;
    }
}
