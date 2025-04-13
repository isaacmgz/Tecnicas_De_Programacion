/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa.AccountingCompany;

/**
 *
 * @author isaacmgz
 */
import com.mycompany.novexa.*;
import static com.mycompany.novexa.tools.ManageFreelancer.freelancers;
import static com.mycompany.novexa.tools.ManageClient.clients;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class SuperviseContract {

    public static ArrayList<ClientContract> contracts = new ArrayList<>();

    public static void createContract() {
        
        ClientContract contract = new ClientContract();
        String nameClient = JOptionPane.showInputDialog("Enter the company's name");
        double totalCost = 0;
        boolean found = false;
        
        for (Client c : clients) {
            if (nameClient.equals(c.getNameClient())) { //Asegurarnos que la empresa esté registrada
                found = true;
                String nameProject = JOptionPane.showInputDialog("Enter the name of the proyect");
                contract.setNameProject(nameProject);
                int durationProject = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of the proyect in months"));
                contract.setDuration(durationProject);
                String idFreelancer = JOptionPane.showInputDialog("Enter the Freelancer's ID for the proyect");
                contract.setClient(c);

                if (verificationFreelancer(idFreelancer)) {
                    Freelancer freelancer = getFreelancerById(idFreelancer);
                    contract.setFreelancer(freelancer);
                    contract.setContractCost(totalCost + (freelancer.getCostPerHour() * durationProject * 160));
                    contracts.add(contract);
                    JOptionPane.showMessageDialog(null, contract.toString());
                }//endIf
                break;
            }//endIf
        }//endFor 
        if (!found) {
            JOptionPane.showMessageDialog(null, "Your company must be registered first, please sign up");
        }
    }

    public static boolean verificationFreelancer(String IdFreelancer) {
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "The ID you provided for the Freelancer does not exist, please enter a valid one");
        return false;
    }

    public static Freelancer getFreelancerById(String IdFreelancer) {
        for (Freelancer f : freelancers) {
            if (f.getIdFreelancer().equals(IdFreelancer)) {
                return f;
            }
        }
        return null;
    }
}
