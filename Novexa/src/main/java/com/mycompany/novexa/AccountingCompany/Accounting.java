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
            
        JOptionPane.showInternalMessageDialog(
            null, "Las ganancias netas generadas por la empresa son de: "+netProfits+
            "\nLas ganancias totales para la empresa es de: "+companyProfits+
            "\nLas ganancias totales generadas para los Freelancer son de"+freelancerEarnings
        );
        }
    }
}
