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
import com.mycompany.novexa.AccountingCompany.Accounting;

public class ManageNovexa {

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

    public static void findFreelancer() {
        String searchId = JOptionPane.showInputDialog("Enter the Freelancer's ID you want to look for");
        Freelancer found = null;
        for (Freelancer f : ManageFreelancer.freelancers) {
            if (f.getIdFreelancer().equals(searchId)) {
                found = f; 
                break;
            }
        }
        if (found != null) {
            ManageFreelancer.displayFreelancer(found.getIdFreelancer());
        } else {
            JOptionPane.showMessageDialog(null, "Freelancer was not found.");
        }
    }
}
