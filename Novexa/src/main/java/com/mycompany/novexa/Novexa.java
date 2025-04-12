/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.novexa;


/**
 *
 * @author isaacmgz
 */

import javax.swing.JOptionPane;
// import com.mycompany.novexa.tools.Management;
import com.mycompany.novexa.tools.ManageNovexa;
import com.mycompany.novexa.tools.ManageFreelancer;
import com.mycompany.novexa.tools.ManageClient;

public class Novexa {
    
    String name = "Novexa Company";
    String location = "Universidad de Antioquia Bloque 18";
        
    public static void principalMenu(){
        String option;
        
        do{
            option = JOptionPane.showInputDialog(
                null,
                "Menú Principal\n\n" +
                "1. enter the Administrator menu\n" +
                "2. enter the Freelancer menu\n" +
                "3. enter the Client menu\n" +
                "4. Exit Novexa\n\n" +
                "Elige una opción:");

            if ("1".equals(option)){
                ManageNovexa.administrationMenu();
            }
            if ("2".equals(option)){
                ManageFreelancer.freelancerMenu();
            }
            if ("3".equals(option)){
                ManageClient.clientMenu();
            }
        }while(!"4".equals(option));
    }
    
    public static void main(String[] args) {
        principalMenu();
    }
}
