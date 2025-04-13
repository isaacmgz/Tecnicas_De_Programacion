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
import com.mycompany.novexa.AccountingCompany.SuperviseContract;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ManageClient {

    public static ArrayList<Client> clients = new ArrayList<>();

    public static void clientMenu() {
        String option;
        do {
            option = JOptionPane.showInputDialog("""
                                                 Client Menu
                                                 
                                                 1. Sign up
                                                 2. Search Freelancer language
                                                 3. Propose Contract
                                                 4. Exit
                                                 
                                                 Choose one option:""");

            switch (option) {
                case "1" -> {
                    addClient();
                    JOptionPane.showMessageDialog(null, "Company was succesfully added!");
                }
                case "2" -> {
                    String option_filter;
                    option_filter = JOptionPane.showInputDialog("""
                                                                How do you want to filter the Freelancers?:
                                                                1. Filter by programming language only
                                                                2. Filter by programming language and seniority""");
                    if (option_filter.equals("1")) {
                        String option_language = JOptionPane.showInputDialog("Enter the language you want to use as filter");
                        filterFreelancerLanguage(option_language);
                    } else if (option_filter.equals("2")) {
                        String option_lan = JOptionPane.showInputDialog("Enter the programming language");
                        String option_seniority = JOptionPane.showInputDialog("Enter the seniority");
                        filterLanguageLevel(option_lan, option_seniority);
                    }
                }

                case "3" -> {
                    SuperviseContract.createContract();
                    JOptionPane.showMessageDialog(null, "Contract was succesfully created!");
                }
            }//endSwitch
        } while (!"4".equals(option));
    }

    public static void filterLanguageLevel(String searchSkill, String seniority) {
        int key = 0;
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getSkill().getLanguageProgramming().equals(searchSkill) && f.getSkill().getSeniority().equals(seniority)) {
                JOptionPane.showMessageDialog(null, "The freelancer" + f.getName() + " with the ID " + f.getIdFreelancer()+ " uses the programming language " + searchSkill + " with a seniority of " + seniority);
                key++;
            }
        }
        if (key == 0) {
            JOptionPane.showMessageDialog(null, "We couldn't find a Freelancer with the language and seniority specified, please try again");
        }
    }

    public static void filterFreelancerLanguage(String searchSkill) {
        int key = 0;
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getSkill().getLanguageProgramming().equals(searchSkill)) {
                JOptionPane.showMessageDialog(null, "The freelancer " + f.getName() + " with the ID "+f.getIdFreelancer() + " uses the programming language " + searchSkill);
                key++;
            }
        }
        if (key == 0) {
            JOptionPane.showMessageDialog(null, "We couldn't find a Freelancer with the language specified, please try a different one");
        }
    }

    public static void addClient() {
        Client client = new Client();
        client.setNameClient(JOptionPane.showInputDialog("Enter the company's name"));
        client.setClientEmail(JOptionPane.showInputDialog("Enter the company's email address"));
        clients.add(client);
    }
}
