/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa.tools;

/**
 *
 * @author isaacmgz
 */

import com.mycompany.novexa.*;
import static com.mycompany.novexa.AccountingCompany.SuperviseContract.contracts;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ManageFreelancer {
    
    public static ArrayList<Freelancer> freelancers = new ArrayList<>();
    
    public static void freelancerMenu(){
        String option;
        
        do {
            option = JOptionPane.showInputDialog(
                "Freelancer Menu\n\n" +
                "1. Sign up\n" +
                "2. Log in\n" +
                "3. Exit\n\n" +
                "Elige una opción:"
            );

            switch(option) {
                case "1":
                    addFreelancer();
                    break;
                case "2":
                    String input = JOptionPane.showInputDialog(null, "Ingrese su IdFreelancer");
                    displayFreelancer(input);
                        for(ClientContract c : contracts){
                            if(c.getFreelancer().getIdFreelancer().equals(input)){
                                JOptionPane.showMessageDialog(null, c.toString());// Mostrar
                                
                                double costo;
                                double comissionn;
                                costo = c.getContractCost();
                                comissionn = costo*0.1;
                                
                                JOptionPane.showMessageDialog(null, "El costo total del contrato un pago de "+costo);
                                JOptionPane.showMessageDialog(null, "Y le corresponde una comisión a la empresa de "+comissionn);
                                JOptionPane.showMessageDialog(null, "A ti te toca:"+(costo-comissionn));
                            }
                         
                        }JOptionPane.showMessageDialog(null, "Aún no tienes contratos");
                    
                    
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting the Admiistrator Menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (!"3".equals(option));
    }
    
    public static void addFreelancer() {

        String option;

        Freelancer freelancer = new Freelancer();
        
        freelancer.setName(JOptionPane.showInputDialog("Agregue el nombre del Freelancer"));
        freelancer.setIdFreelancer(JOptionPane.showInputDialog("Agregue el Id del Freelancer")); 
        freelancer.setEmailFreelancer(JOptionPane.showInputDialog("Agregue el correo del Freelancer"));
        freelancer.setCostPerHour(Integer.parseInt(JOptionPane.showInputDialog("Agregue el costo por hora del Freelancer ($USD)"))); 
        freelancer.setNationality(JOptionPane.showInputDialog("Agregue la nacionalidad del Freelancer"));

        do {
            option = JOptionPane.showInputDialog(
                null,
                "Administrate Freelancer \n\n " +
                "1. Add a skill\n " +
                "2. Add Work Experience\n " +
                "3. Add Academic Record \n " +
                "4. Exit \n\n" +
                "Elige una opción:");

            switch(option){
                case "1":
                    Skill skill = new Skill(); // Se crea objeto Skill
                    
                    String nameSkill = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    skill.setLanguageProgramming(nameSkill);
                    freelancer.setSkill(skill);
                    
                    String levelSkill = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    skill.setLevel(levelSkill);
                    freelancer.setSkill(skill);
                    
                    String englishLevel = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    skill.setEnglishLevel(englishLevel);
                    freelancer.setSkill(skill);
                    
                    String additionalSkills = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    skill.setAdditionalSkills(additionalSkills);
                    freelancer.setSkill(skill);
                    break;
                case "2":
                    WorkExperience workExperience = new WorkExperience();
                    
                    String nameCompany = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    workExperience.setCompanyName(nameCompany);
                    freelancer.setWorkExperience(workExperience);
                    
                    String namePosition = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    workExperience.setPosition(namePosition);
                    freelancer.setWorkExperience(workExperience);
                    
                    String rolSpecification = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    workExperience.setRolSpecification(rolSpecification);
                    freelancer.setWorkExperience(workExperience);
                    
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nombre de la Skill"));
                    workExperience.setDuration(duration);
                    freelancer.setWorkExperience(workExperience);
                    break;
                case "3":
                    AcademicRecord academicRecord = new AcademicRecord();
                    
                    String nameDegree = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    academicRecord.setDegree(nameDegree);
                    freelancer.setAcademicRecord(academicRecord);
                    
                    String nameInstitution = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    academicRecord.setInstitution(nameInstitution);
                    freelancer.setAcademicRecord(academicRecord);
                    
                    String year = JOptionPane.showInputDialog("Ingrese el nombre de la Skill");
                    academicRecord.setYear(year);
                    freelancer.setAcademicRecord(academicRecord);
                    break;
            }
        } while(!"4".equals(option));

    freelancers.add(freelancer);
    JOptionPane.showMessageDialog(null, "Freelancer agregado correctamente.");
    }
    
    public static void displayFreelancer(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                JOptionPane.showMessageDialog(null, f.toString());
            }else {
                JOptionPane.showMessageDialog(null, "Este Freelancer no esta registrado");
            }
        }       
    }
}
