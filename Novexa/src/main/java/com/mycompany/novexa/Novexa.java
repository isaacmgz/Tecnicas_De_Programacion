
/**
 * Main class for the Novexa application.
 * This class serves as the entry point and provides a menu to navigate between 
 * the administration, freelancer, and client menus.
 */

package com.mycompany.novexa;

import javax.swing.JOptionPane;
import com.mycompany.novexa.tools.ManageNovexa;
import com.mycompany.novexa.tools.ManageFreelancer;
import com.mycompany.novexa.tools.ManageClient;

public class Novexa {

    // The name of the company displayed in the menu
    static String name = "Novexa S.A.S";

    /**
     * Displays the principal menu of the application.
     * The user can choose between accessing the Admin menu, Freelancer menu,
     * Client menu, or exiting the application.
     */
    public static void principalMenu() {
        String option;

        do {
            // Display the menu and prompt the user for an option
            option = JOptionPane.showInputDialog(null, name + """
                                                        - MENU   
                                                       
                                                       1. Enter the Admin menu
                                                       2. Enter the Freelancer menu
                                                       3. Enter the Client menu
                                                       4. Exit Novexa
                                                       
                                                       Choose one option:""");

            // Redirect to the appropriate menu based on the user's input
            if ("1".equals(option)) {
                ManageNovexa.administrationMenu(); // Call the Admin menu
            }
            if ("2".equals(option)) {
                ManageFreelancer.freelancerMenu(); // Call the Freelancer menu
            }
            if ("3".equals(option)) {
                ManageClient.clientMenu(); // Call the Client menu
            }
        } while (!"4".equals(option)); // Exit the loop when option "4" is selected
    }

    /**
     * Main method of the application.
     * It invokes the principal menu to start the application.
     */
    public static void main(String[] args) {
        principalMenu();
    }
}