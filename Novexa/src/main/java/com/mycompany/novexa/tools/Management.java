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
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Management {
    
    private ArrayList<Freelancer> freelancers = new ArrayList<>();
    private ArrayList<ClientContract> contracts = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();


    public void administrationMenu() {
        String option;
        
        do {
            option = JOptionPane.showInputDialog(
                "Administrator Menu\n\n" +
                "1. Add a Freelancer\n" +
                "2. Find a Freelancer\n" +
                "3. Exit\n\n" +
                "Elige una opción:"
            );

            switch(option) {
                case "1":
                    String input = JOptionPane.showInputDialog(null, "Exiting the Admiistrator Menu");
                    filterFreelancerLanguage(input);
                    break;
                case "2":
                    findFreelancer();
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
    
    public void freelancerMenu(){
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
                    String input = JOptionPane.showInputDialog(null, "IdFreelancer");
                    displayFreelancer(input);
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
    
    private void addFreelancer() {

        String option;

        Freelancer freelancer = new Freelancer();
        
        freelancer.setName(JOptionPane.showInputDialog("Agregue el nombre del Freelancer"));
        freelancer.setIdFreelancer(JOptionPane.showInputDialog("Agregue el Id del Freelancer"));
        freelancer.setEmailFreelancer(JOptionPane.showInputDialog("Agregue el correo del Freelancer"));
        freelancer.setCostPerHour(Integer.parseInt(JOptionPane.showInputDialog("Agregue el costo por hora del Freelancer")));
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
    
    public void filterFreelancerLanguage(String searchSkill){
        for(Freelancer f : freelancers){
            if(f.getSkill().getLanguageProgramming().equals(searchSkill)){
                System.out.println("El freelancer"+f+"Usa el lenguaje"+ searchSkill);
            }
        }
    }
    
    private void displayFreelancer(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                System.out.println(f.toString());
            }else {
                System.out.println("Este Freelancer no esta registrado");
            }
        }       
    }

    private void findFreelancer() {
        String searchId = JOptionPane.showInputDialog("Ingrese el Id del Freelancer a buscar");
        Freelancer found = null;
        for(Freelancer f : freelancers) {
            if(f.getIdFreelancer().equals(searchId)) {
                found = f;
                break;
            }
        }
        if(found != null) {
            JOptionPane.showMessageDialog(null, "Freelancer encontrado: " + found.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Freelancer no encontrado.");
        }
    }
    
    public boolean verificationFreelancer(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                return true;
            }
        }System.out.println("Este Freelancer no está registrado");
        return false;
    }
    
    public Freelancer getFreelancerById(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                return f;
            }
        }return null;
    }
    
    private void ClientMenu(){
          String option;
        
        do {
            option = JOptionPane.showInputDialog(
                "Client Menu\n\n" +
                "1. Sign up"+
                "2. Search Freelancer Skill\n" +
                "3. Propose Contract\n" +
                "4. Exit\n\n" +
                "Elige una opción:"
            );

            switch(option) {
                case "1":
                    
                case "2":
                    String option_filter = JOptionPane.showInputDialog("Desea Buscar por \n1. Buscar sólo por lenguaje de programación \n2. Buscar por lenguaje de programacion y senority ");
                    if(option_filter.equals("1")){
                        String option_language = JOptionPane.showInputDialog("Por cuál lenguaje quiere filtrar");
                        filterFreelancerLanguage(option_language);
                    }else if(option_filter.equals("2")){
                        String option_lan = JOptionPane.showInputDialog("Ingrese el lenguaje");
                        String option_level = JOptionPane.showInputDialog("Ingrese el nivel");
                        filterLanguageLevel(option_lan, option_level);
                    }
                    break;
                case "3":
                    String input = JOptionPane.showInputDialog(null, "IdFreelancer");
                    displayFreelancer(input);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Exiting the Admiistrator Menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (!"4".equals(option));
    }
    private void filterLanguageLevel(String searchSkill, String level){
        for(Freelancer f : freelancers){
            if(f.getSkill().getLanguageProgramming().equals(searchSkill) && f.getSkill().getLevel().equals(level)){
                System.out.println("El freelancer"+f+"Usa el lenguaje"+ searchSkill + "y tiene un nivel de"+ level);
            }
        }
    }
    
    public void addClient(){
        Client client = new Client();
        
        client.setNameClient(JOptionPane.showInputDialog("Agregue el nombre del Client"));
        client.setClientEmail(JOptionPane.showInputDialog("Agregue el Id del Freelancer"));
        
        clients.add(client);
    }
    
    
    
    public void ManageCon(){
        
        ClientContract contract = new ClientContract();
        String nameClient = JOptionPane.showInputDialog("Ingrese el nombre de su empresa");
        
        for ( Client c : clients){
            
            if(nameClient.equals(c.getNameClient())){
                String nameProject = JOptionPane.showInputDialog("Ingrese el nombre del proyecto");
                contract.setNameProject(nameProject);
                int durationProject = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración del proyecto en meses"));
                contract.setDuration(durationProject);
                String idFreelancer = JOptionPane.showInputDialog("Ingrese el ID del Freelancer a contratar");
                while (verificationFreelancer(idFreelancer)){
                    contract.setFreelancer(getFreelancerById(idFreelancer));
                String opcion;
                do{
                    opcion = JOptionPane.showInputDialog("Desea agregar otro freelancer 1.Si\n2.No");                    
                    if (opcion.equals("1")){
                        String idFreelancerNew = JOptionPane.showInputDialog("Ingrese el ID del Freelancer a contratar");
                        while (verificationFreelancer(idFreelancerNew)){
                        contract.setFreelancer(getFreelancerById(idFreelancerNew));
                        }
                    }
                }while(!"2".equals(opcion));
                }
               
            }
        }
        
    } 
}
