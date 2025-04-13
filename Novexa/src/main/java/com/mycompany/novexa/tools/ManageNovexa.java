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
            option = JOptionPane.showInputDialog(
                "Administrator Menu\n\n" +
                "1. Find a Freelancer\n" +
                "2. Check bank state\n" + 
                "3. Exit\n\n" +
                "Elige una opción:"
            );
            switch(option) {
                case "1":
                    findFreelancer();
                    break;
                case "2":
                    Accounting.accountStatement();
                    break;
            }
        } while (!"3".equals(option));
    }
    
    public static void findFreelancer() {
        String searchId = JOptionPane.showInputDialog("Ingrese el Id del Freelancer a buscar");
        Freelancer found = null;
        for(Freelancer f : ManageFreelancer.freelancers) {
            if(f.getIdFreelancer().equals(searchId)) {
                found = f;
                break;
            }
        }
        if(found != null) {
            JOptionPane.showMessageDialog(null, "Freelancer encontrado: " + found.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Freelancer no encontrado.");
        }
    }
}
