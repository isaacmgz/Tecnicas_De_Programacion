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

public class ManageClient {
    
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
        for(Freelancer f : ManageFreelancer.freelancers){
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
}
