
/*
 * This class is part of the AccountingCompany package and is responsible for managing freelance contracts
 * between clients and freelancers. It provides methods to create contracts, verify freelancer details,
 * and retrieve freelancer information by ID.
 */
package com.mycompany.novexa.AccountingCompany;

import com.mycompany.novexa.*;
import static com.mycompany.novexa.tools.ManageFreelancer.freelancers;
import static com.mycompany.novexa.tools.ManageClient.clients;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class SuperviseContract {

    // List of all contracts created
    public static ArrayList<ClientContract> contracts = new ArrayList<>();

    /**
     * Creates a new contract between a client and a freelancer. 
     * Prompts the user to input details such as the client's name, project name, 
     * project duration, and freelancer's ID. Verifies that the client is registered 
     * and the freelancer ID is valid. Calculates the total cost of the contract and stores it.
     */
    public static void createContract() {
        ClientContract contract = new ClientContract();
        String nameClient = JOptionPane.showInputDialog("Enter the company's name");
        double totalCost = 0;
        boolean found = false;

        // Search for the client in the registered clients list
        for (Client c : clients) {
            if (nameClient.equals(c.getNameClient())) { // Ensure the company is registered
                found = true;
                String nameProject = JOptionPane.showInputDialog("Enter the name of the project");
                contract.setNameProject(nameProject);
                int durationProject = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of the project in months"));
                contract.setDuration(durationProject);
                String idFreelancer = JOptionPane.showInputDialog("Enter the Freelancer's ID for the project");
                contract.setClient(c);

                // Verify freelancer ID and calculate the contract cost
                if (verificationFreelancer(idFreelancer)) {
                    Freelancer freelancer = getFreelancerById(idFreelancer);
                    contract.setFreelancer(freelancer);
                    contract.setContractCost(totalCost + (freelancer.getCostPerHour() * durationProject * 160));
                    contracts.add(contract);
                    JOptionPane.showMessageDialog(null, contract.toString());
                }
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Your company must be registered first, please sign up");
        }
    }

    /**
     * Verifies if a freelancer with the given ID exists in the system.
     * 
     * @param IdFreelancer The ID of the freelancer to verify.
     * @return true if the freelancer exists, false otherwise.
     */
    public static boolean verificationFreelancer(String IdFreelancer) {
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "The ID you provided for the Freelancer does not exist, please enter a valid one");
        return false;
    }

    /**
     * Retrieves a Freelancer object by their ID.
     * 
     * @param IdFreelancer The ID of the freelancer.
     * @return The Freelancer object if found, or null if not found.
     */
    public static Freelancer getFreelancerById(String IdFreelancer) {
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                return f;
            }
        }
        return null;
    }
}