/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa;

/**
 *
 * @author isaacmgz
 */
public class Skill {
    
    private String languageProgramming;
    private String seniority;

    public Skill() {
    }

    public Skill(String languageProgramming, String seniority) {
        this.languageProgramming = languageProgramming;
        this.seniority = seniority;
    }

    public String getLanguageProgramming() {
        return languageProgramming;
    }

    public void setLanguageProgramming(String languageProgramming) {
        this.languageProgramming = languageProgramming;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
    
    @Override
    public String toString() {
        return "Skill:" + "\n languageProgramming=" + languageProgramming + "\n seniority=" + seniority +'}';
    }
    
    
}
