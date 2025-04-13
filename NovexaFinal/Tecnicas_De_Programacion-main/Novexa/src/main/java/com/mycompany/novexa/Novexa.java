/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.novexa;

/**
 *
 * @author isaacmgz
 */
import javax.swing.JOptionPane;
import com.mycompany.novexa.tools.ManageNovexa;
import com.mycompany.novexa.tools.ManageFreelancer;
import com.mycompany.novexa.tools.ManageClient;

public class Novexa {

    static String name = "Novexa S.A.S";

    public static void principalMenu() {
        String option;

        do {
            option = JOptionPane.showInputDialog(null, name + """
                                                        - MENU   
                                                       
                                                       1. Enter the Admin menu
                                                       2. Enter the Freelancer menu
                                                       3. Enter the Client menu
                                                       4. Exit Novexa
                                                       
                                                       Choose one option:""");

            if ("1".equals(option)) {
                ManageNovexa.administrationMenu();
            }
            if ("2".equals(option)) {
                ManageFreelancer.freelancerMenu();
            }
            if ("3".equals(option)) {
                ManageClient.clientMenu();
            }
        } while (!"4".equals(option));
    }

    public static void main(String[] args) {
        principalMenu();
    }

}
