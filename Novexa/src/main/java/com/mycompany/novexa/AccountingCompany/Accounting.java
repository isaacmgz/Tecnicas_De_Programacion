
/**
 * The Accounting class provides functionality to calculate and display
 * financial summaries for the company and its freelancers based on client contracts.
 * It computes the net profits, company profits, and freelancer earnings.
 */

package com.mycompany.novexa.AccountingCompany;

import com.mycompany.novexa.*;
import static com.mycompany.novexa.AccountingCompany.SuperviseContract.contracts;
import javax.swing.JOptionPane;


public class Accounting {

    /**
     * Generates and displays the financial summary of all client contracts.
     * 
     * The method calculates:
     * - Total net profits from all contracts.
     * - The company's share of profits (10% of each contract's cost).
     * - The total earnings of freelancers (remaining 90% of each contract's cost).
     * 
     * The results are displayed in a dialog box.
     */
    public static void accountStatement() {
        double netProfits = 0;          // Total net profits from all contracts
        double freelancerEarnings = 0; // Total earnings of freelancers
        double companyProfits = 0;     // Total earnings of the company (10% of contract cost)

        // Iterate through all contracts and calculate profits and earnings
        for (ClientContract c : contracts) {
            netProfits += c.getContractCost(); // Add contract cost to net profits
            companyProfits += c.getContractCost() * 0.1; // Add 10% of contract cost to company profits
            freelancerEarnings += c.getContractCost() - c.getContractCost() * 0.1; // Add 90% of contract cost to freelancer earnings
        }

        // Display the financial summary in a dialog box
        JOptionPane.showInternalMessageDialog(
            null, "The net earnings of the company are: " + netProfits +
            "\nThe total earnings of the company are: " + companyProfits +
            "\nThe total earnings of the Freelancers are: " + freelancerEarnings
        );
    }
}