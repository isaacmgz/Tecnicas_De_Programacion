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
import static com.mycompany.novexa.AccountingCompany.SuperviseContract.contracts;
import javax.swing.JOptionPane;

public class Accounting {
 
    public static void accountStatement(){
        
        double netProfits = 0;
        double freelancerEarnings = 0;
        double companyProfits = 0;
        
        for (ClientContract c : contracts){
            netProfits = netProfits + c.getContractCost();
            companyProfits = companyProfits + c.getContractCost()*0.1;
            freelancerEarnings = freelancerEarnings + (c.getContractCost()-c.getContractCost()*0.1);
        }    
        JOptionPane.showInternalMessageDialog(
            null, "The net earnings of the company are: "+netProfits+
            "\nThe total earnings of the company are: "+companyProfits+
            "\nThe total earnings of the Freelancers are: "+freelancerEarnings
        );
    }
}
