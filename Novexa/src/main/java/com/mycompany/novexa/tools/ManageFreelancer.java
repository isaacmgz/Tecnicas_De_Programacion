
/*
 * This class provides tools to manage freelancers, including signing up, logging in,
 * and displaying freelancer details. It allows adding programming skills,
 * work experiences, and academic records to freelancers.
 */
package com.mycompany.novexa.tools;

import com.mycompany.novexa.*;
import static com.mycompany.novexa.AccountingCompany.SuperviseContract.contracts;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class ManageFreelancer {

    // A list to store all registered freelancers
    public static ArrayList<Freelancer> freelancers = new ArrayList<>();

    /**
     * Displays the Freelancer Menu where users can:
     * - Sign up as a new freelancer
     * - Log in to view their contracts and earnings
     * - Exit the menu
     */
    public static void freelancerMenu() {
        String option;
        do {
            // Prompt the user to choose an option
            option = JOptionPane.showInputDialog("""
                                                 Freelancer Menu
                                                 
                                                 1. Sign up
                                                 2. Log in
                                                 3. Exit
                                                 
                                                 Choose one option:""");
            switch (option) {
                case "1" -> addFreelancer(); // Call method to sign up a new freelancer
                case "2" -> {
                    // Prompt the user to enter their Freelancer ID
                    String input = JOptionPane.showInputDialog(null, "Enter your Freelancer ID");
                    displayFreelancer(input); // Display freelancer details
                    boolean gotContract = false;

                    // Check if the freelancer has any contracts
                    for (ClientContract c : contracts) {
                        if (c.getFreelancer().getIdFreelancer().equals(input)) {
                            JOptionPane.showMessageDialog(null, c.toString()); // Show contract details
                            gotContract = true;

                            // Calculate and display the costs and earnings
                            double costo = c.getContractCost();
                            double comissionn = costo * 0.1;
                            JOptionPane.showMessageDialog(
                                    null, "The total cost of the project " + c.getNameProject() + " will be " + costo + " $USD"
                                    + "\nWith a commission for the company of  " + comissionn + " $USD"
                                    + "\nThe total you earned is " + (costo - comissionn) + " $USD");
                        }
                    }

                    // Notify if no contracts are found
                    if (!gotContract) {
                        JOptionPane.showMessageDialog(null, "You don't have contracts yet");
                    }
                }
            }
        } while (!"3".equals(option)); // Exit the loop if the user chooses option 3
    }

    /**
     * Allows the user to sign up a new freelancer by providing their details,
     * including skills, work experiences, and academic records.
     */
    public static void addFreelancer() {
        String option;
        Freelancer freelancer = new Freelancer();

        // Prompt the user to enter freelancer's basic details
        freelancer.setName(JOptionPane.showInputDialog("Enter the Freelancer's name"));
        freelancer.setIdFreelancer(JOptionPane.showInputDialog("Enter the Freelancer's ID"));
        freelancer.setEmailFreelancer(JOptionPane.showInputDialog("Enter the Freelancer's email address"));
        freelancer.setCostPerHour(Integer.parseInt(JOptionPane.showInputDialog("Enter the Freelancer's hour rate ($USD)")));
        freelancer.setNationality(JOptionPane.showInputDialog("Enter the Freelancer's nationality"));
        freelancer.setEnglishLevel(JOptionPane.showInputDialog("Enter the Freelancer's English level"));

        do {
            // Menu for adding additional details to the freelancer
            option = JOptionPane.showInputDialog(null, """
                                                       Administrate Freelancer 
                                                       
                                                        1. Add programming languages
                                                        2. Add Work Experiences
                                                        3. Add Academic Records
                                                        4. Exit 
                                                       
                                                       Choose one option:""");
            switch (option) {
                case "1" -> {
                    // Add a programming language skill
                    Skill skill = new Skill();
                    String nameSkill = JOptionPane.showInputDialog("Enter the programming language");
                    skill.setLanguageProgramming(nameSkill);
                    String senioritySkill = JOptionPane.showInputDialog("Enter the seniority for the language");
                    skill.setSeniority(senioritySkill);
                    freelancer.setSkill(skill);
                    freelancer.skills.add(skill);
                }
                case "2" -> {
                    // Add work experience
                    WorkExperience workExperience = new WorkExperience();
                    String nameCompany = JOptionPane.showInputDialog("Enter the company's name");
                    workExperience.setCompanyName(nameCompany);
                    String namePosition = JOptionPane.showInputDialog("Enter your position in the company");
                    workExperience.setPosition(namePosition);
                    String rolSpecification = JOptionPane.showInputDialog("Enter your role in the company");
                    workExperience.setRolSpecification(rolSpecification);
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("How long did you work in the company? (months)"));
                    workExperience.setDuration(duration);
                    freelancer.setWorkExperience(workExperience);
                    freelancer.workExperiences.add(workExperience);
                }
                case "3" -> {
                    // Add academic record
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
        } while (!"4".equals(option)); // Exit the loop if the user chooses option 4

        // Add the freelancer to the list and display a success message
        freelancers.add(freelancer);
        JOptionPane.showMessageDialog(null, "Freelancer was successfully created!");
    }

    /**
     * Displays the details of a freelancer based on their ID.
     * If the freelancer is not found, shows an error message.
     *
     * @param IdFreelancer the unique ID of the freelancer
     */
    public static void displayFreelancer(String IdFreelancer) {
        boolean gotRegister = false;

        // Search for the freelancer with the given ID
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                // Display freelancer details in a scrollable text area
                JTextArea textArea = new JTextArea(f.toString());
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 550));
                JOptionPane.showMessageDialog(null, scrollPane, "Freelancer Info", JOptionPane.INFORMATION_MESSAGE);
                gotRegister = true;
                break;
            }
        }

        // Notify if the freelancer is not registered
        if (!gotRegister) {
            JOptionPane.showMessageDialog(null, "Freelancer is not registered");
        }
    }
}