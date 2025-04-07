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
    private String level;
    private String englishLevel;
    private String additionalSkills;

    public Skill() {
    }

    public Skill(String languageProgramming, String level, String englishLevel, String additionalSkills) {
        this.languageProgramming = languageProgramming;
        this.level = level;
        this.englishLevel = englishLevel;
        this.additionalSkills = additionalSkills;
    }

    public String getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String additionalSkills) {
        this.additionalSkills = additionalSkills;
    }

    public String getLanguageProgramming() {
        return languageProgramming;
    }

    public void setLanguageProgramming(String languageProgramming) {
        this.languageProgramming = languageProgramming;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }
    
}
