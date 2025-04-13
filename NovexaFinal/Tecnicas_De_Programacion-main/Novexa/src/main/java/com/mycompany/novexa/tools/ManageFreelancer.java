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
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class ManageFreelancer {

    public static ArrayList<Freelancer> freelancers = new ArrayList<>();

    public static void freelancerMenu() {
        String option;
        do {
            option = JOptionPane.showInputDialog("""
                                                 Freelancer Menu
                                                 
                                                 1. Sign up
                                                 2. Log in
                                                 3. Exit
                                                 
                                                 Choose one option:""");
            switch (option) {
                case "1" ->
                    addFreelancer();
                case "2" -> {
                    String input = JOptionPane.showInputDialog(null, "Enter your Freelancer ID");
                    displayFreelancer(input);
                    boolean gotContract = false;
                    for (ClientContract c : contracts) {
                        if (c.getFreelancer().getIdFreelancer().equals(input)) {
                            JOptionPane.showMessageDialog(null, c.toString());// Mostrar
                            gotContract = true;
                            double costo;
                            double comissionn;
                            costo = c.getContractCost();
                            comissionn = costo * 0.1;
                            JOptionPane.showMessageDialog(
                                    null, "The total cost of the proyect " + c.getNameProject() + " will be " + costo + " $USD"
                                    + "\nWith a commission for the company of  " + comissionn + " $USD"
                                    + "\nThe total you earned it is " + (costo - comissionn) + " $USD");
                        }//endIf
                    }
                    if (!gotContract) {
                        JOptionPane.showMessageDialog(null, "You don't have contracts yet");
                    }
                }
            }//endSwitch
        } while (!"3".equals(option));
    }

    public static void addFreelancer() {
        String option;
        Freelancer freelancer = new Freelancer();
        freelancer.setName(JOptionPane.showInputDialog("Enter the Freelancer's name"));
        freelancer.setIdFreelancer(JOptionPane.showInputDialog("Enter the Freelancer's ID"));
        freelancer.setEmailFreelancer(JOptionPane.showInputDialog("Enter the Freelancer's email address"));
        freelancer.setCostPerHour(Integer.parseInt(JOptionPane.showInputDialog("Enter the Freelancer's hour rate ($USD)")));
        freelancer.setNationality(JOptionPane.showInputDialog("Enter the Freelancer's nationality"));
        freelancer.setEnglishLevel(JOptionPane.showInputDialog("Enter the Freelancer's english level"));

        do {
            option = JOptionPane.showInputDialog(null, """
                                                       Administrate Freelancer 
                                                       
                                                        1. Add programming languages
                                                        2. Add Work Experiences
                                                        3. Add Academic Records
                                                        4. Exit 
                                                       
                                                       Choose one option:""");
            switch (option) {
                case "1" -> {
                    Skill skill = new Skill(); // Se crea objeto Skill
                    String nameSkill = JOptionPane.showInputDialog("Enter the programming language");
                    skill.setLanguageProgramming(nameSkill);
                    String senioritySkill = JOptionPane.showInputDialog("Enter the seniority for the language");
                    skill.setSeniority(senioritySkill);
                    freelancer.setSkill(skill);
                    freelancer.skills.add(skill);
                }
                case "2" -> {
                    WorkExperience workExperience = new WorkExperience();
                    String nameCompany = JOptionPane.showInputDialog("Enter the company's name");
                    workExperience.setCompanyName(nameCompany);
                    String namePosition = JOptionPane.showInputDialog("Enter your position on the company");
                    workExperience.setPosition(namePosition);
                    String rolSpecification = JOptionPane.showInputDialog("Enter your rol on the company");
                    workExperience.setRolSpecification(rolSpecification);
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("How long did you work on the company?(months)"));
                    workExperience.setDuration(duration);
                    freelancer.setWorkExperience(workExperience);
                    freelancer.workExperiences.add(workExperience);
                }
                case "3" -> {
                    AcademicRecord academicRecord = new AcademicRecord();
                    String nameDegree = JOptionPane.showInputDialog("Enter your degree or course completed");
                    academicRecord.setDegree(nameDegree);
                    String nameInstitution = JOptionPane.showInputDialog("Enter the institution's name");
                    academicRecord.setInstitution(nameInstitution);
                    String year = JOptionPane.showInputDialog("Enter the year of completion");
                    academicRecord.setYear(year);
                    freelancer.setAcademicRecord(academicRecord);
                    freelancer.academicRecords.add(academicRecord);
                }
            }
        } while (!"4".equals(option));

        freelancers.add(freelancer);
        JOptionPane.showMessageDialog(null, "Freelancer was succesfully created!");
    }

    public static void displayFreelancer(String IdFreelancer) {
        boolean gotRegister = false;
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                JTextArea textArea = new JTextArea(f.toString());
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 550)); // Ajusta el tamaño del panel
                JOptionPane.showMessageDialog(null, scrollPane, "Freelancer Info", JOptionPane.INFORMATION_MESSAGE);
            }
            break;
        }
        if (gotRegister) {
            JOptionPane.showMessageDialog(null, "Freelancer is not registered");
        }
    }

}
