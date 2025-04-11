/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.novexa;


/**
 *
 * @author isaacmgz
 */

import javax.swing.JOptionPane;
import com.mycompany.novexa.tools.Management;

public class Novexa {
    
    String name;
    String location;
    
    static ClientContract contract;
    
    public static void principalMenu(){
        String option;
        Management management = new Management(); // tool 
        
        option = JOptionPane.showInputDialog(
            null,
            "Menú Principal\n\n" +
            "1. enter the Administrator menu\n" +
            "2. enter the Freelancer menu\n" +
            "3. enter the Client menu\n\n" +
            "Elige una opción:");
        
        if ("1".equals(option)){
            management.administrationMenu();
        }
        if ("2".equals(option)){
            management.freelancerMenu();
        }
        if ("3".equals(option)){
            Client client = new Client();
            management.clientMenu();
        }
    }
    
    public static void main(String[] args) {
        
    }
}
