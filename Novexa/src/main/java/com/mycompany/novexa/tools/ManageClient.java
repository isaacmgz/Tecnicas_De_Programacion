
/*
 * This class provides functionality to manage clients and their interactions
 * with freelancers. It includes features like signing up new clients, filtering
 * freelancers based on programming languages and seniority, and creating contracts.
 */
package com.mycompany.novexa.tools;

import com.mycompany.novexa.*;
import com.mycompany.novexa.AccountingCompany.SuperviseContract;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * The ManageClient class provides methods for managing client-related operations
 * such as adding clients, filtering freelancers, and proposing contracts.
 * It serves as part of the Novexa toolset for managing freelancer-client interactions.
 * 
 */
public class ManageClient {

    // A list to store all the clients added to the system
    public static ArrayList<Client> clients = new ArrayList<>();

    /**
     * Displays a menu for client-related operations, allowing users to
     * add clients, search for freelancers, propose contracts, or exit the menu.
     */
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
                    JOptionPane.showMessageDialog(null, "Company was successfully added!");
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
                    JOptionPane.showMessageDialog(null, "Contract was successfully created!");
                }
            }
        } while (!"4".equals(option));
    }

    /**
     * Filters freelancers based on a specified programming language and seniority level.
     * If no matching freelancers are found, a message is displayed.
     * 
     * @param searchSkill The programming language to filter by.
     * @param seniority The seniority level to filter by.
     */
    public static void filterLanguageLevel(String searchSkill, String seniority) {
        int key = 0;
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getSkill().getLanguageProgramming().equals(searchSkill) && f.getSkill().getSeniority().equals(seniority)) {
                JOptionPane.showMessageDialog(null, "The freelancer " + f.getName() + " with the ID " + f.getIdFreelancer() +
                        " uses the programming language " + searchSkill + " with a seniority of " + seniority);
                key++;
            }
        }
        if (key == 0) {
            JOptionPane.showMessageDialog(null, "We couldn't find a Freelancer with the language and seniority specified, please try again");
        }
    }

    /**
     * Filters freelancers based on a specified programming language.
     * If no matching freelancers are found, a message is displayed.
     * 
     * @param searchSkill The programming language to filter by.
     */
    public static void filterFreelancerLanguage(String searchSkill) {
        int key = 0;
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getSkill().getLanguageProgramming().equals(searchSkill)) {
                JOptionPane.showMessageDialog(null, "The freelancer " + f.getName() + " with the ID " + f.getIdFreelancer() +
                        " uses the programming language " + searchSkill);
                key++;
            }
        }
        if (key == 0) {
            JOptionPane.showMessageDialog(null, "We couldn't find a Freelancer with the language specified, please try a different one");
        }
    }

    /**
     * Adds a new client to the system. Adds a new client to the system. The client's name and email address are collected
     * through input dialogs and stored in the clients list.
     */
    public static void addClient() {
        Client client = new Client();
        client.setNameClient(JOptionPane.showInputDialog("Enter the company's name"));
        client.setClientEmail(JOptionPane.showInputDialog("Enter the company's email address"));
        clients.add(client);
    }
}