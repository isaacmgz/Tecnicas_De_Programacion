
/**
 * This class provides provides administrative functionalities for the Novexa application.
 * It includes menu-driven operations to find freelancers and check the company's bank state.
 */

package com.mycompany.novexa.tools;

import com.mycompany.novexa.*;
import javax.swing.JOptionPane;
import com.mycompany.novexa.AccountingCompany.Accounting;

public class ManageNovexa {

    /**
     * Displays the administration menu and handles user input for different administrative tasks.
     * The menu provides options to find a freelancer, check the bank state, and exit the menu.
     */
    public static void administrationMenu() {
        String option;
        do {
            option = JOptionPane.showInputDialog("""
                                                 Administrator Menu
                                                 
                                                 1. Find a Freelancer
                                                 2. Check bank state
                                                 3. Exit
                                                 
                                                 Choose one option:""");
            switch (option) {
                case "1" ->
                    findFreelancer();
                case "2" ->
                    Accounting.accountStatement();
            }
        } while (!"3".equals(option));
    }

    /**
     * Searches for a freelancer by their ID. If found, displays the freelancer's details.
     * If not found, shows an error message.
     */
    public static void findFreelancer() {
        // Prompt the user for the freelancer's ID
        String searchId = JOptionPane.showInputDialog("Enter the Freelancer's ID you want to look for");
        Freelancer found = null;

        // Iterate through the list of freelancers to find a match
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getIdFreelancer().equals(searchId)) {
                found = f; 
                break;
            }
        }

        // Display the freelancer's details if found, otherwise show an error message
        if (found != null) {
            ManageFreelancer.displayFreelancer(found.getIdFreelancer());
        } else {
            JOptionPane.showMessageDialog(null, "Freelancer was not found.");
        }
    }
}