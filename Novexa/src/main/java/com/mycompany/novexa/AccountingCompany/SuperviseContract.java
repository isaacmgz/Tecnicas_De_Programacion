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
    
    public static void createContract(){
        
        ClientContract contract = new ClientContract();
        String nameClient = JOptionPane.showInputDialog("Ingrese el nombre de su empresa");
        
        double totalCost=0;
        boolean found = false;

        for ( Client c : clients){
            if(nameClient.equals(c.getNameClient())){ //Asegurarnos que la empresa esté registrada
                found=true;
                
                String nameProject = JOptionPane.showInputDialog("Ingrese el nombre del proyecto");
                contract.setNameProject(nameProject);
                
                int durationProject = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración del proyecto en meses"));
                contract.setDuration(durationProject);
                
                String idFreelancer = JOptionPane.showInputDialog("Ingrese el ID del Freelancer a contratar");
                contract.setClient(c);
                
                if (verificationFreelancer(idFreelancer)) {
                    Freelancer freelancer = getFreelancerById(idFreelancer);
                    contract.setFreelancer(freelancer);
                    contract.setContractCost(totalCost + (freelancer.getCostPerHour() * durationProject * 160));
                    contracts.add(contract);
                    JOptionPane.showMessageDialog(null,contract.toString());
                }//endIf
                break;
            }//endIf
        }//endFor 
        if(!found){
                JOptionPane.showMessageDialog(null,"Asegurese que su empresa esté registrada primero");
            }
    }
    
    public static boolean verificationFreelancer(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                return true;
            }
        }JOptionPane.showMessageDialog(null,"Este Freelancer no está registrado");
        return false;
    }
    
    public static Freelancer getFreelancerById(String IdFreelancer){
        for(Freelancer f: freelancers){
            if(f.getIdFreelancer().equals(IdFreelancer)){
                return f;
            }
        }return null;
    }
}
