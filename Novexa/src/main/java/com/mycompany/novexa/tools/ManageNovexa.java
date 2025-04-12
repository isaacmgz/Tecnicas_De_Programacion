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

public class ManageNovexa {
    
    public static void administrationMenu() {
        String option;
        
        do {
            option = JOptionPane.showInputDialog(
                "Administrator Menu\n\n" +
                "1. Add a Freelancer\n" +
                "2. Find a Freelancer\n" +
                "3. Check bank state\n" + // Pendiente por hacer
                "4. Exit\n\n" +
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
    
    public static void filterFreelancerLanguage(String searchSkill) {
        for(Freelancer f : ManageFreelancer.freelancers){
            if(f.getSkill().getLanguageProgramming().equals(searchSkill)){
                JOptionPane.showMessageDialog(null, "El freelancer"+f+"Usa el lenguaje"+ searchSkill);
            }
        }
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
            JOptionPane.showMessageDialog(null, "Freelancer encontrado: " + found.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Freelancer no encontrado.");
        }
    }
}
