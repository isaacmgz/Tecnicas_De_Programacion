/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.novexa;

/**
 *
 * @author isaacmgz
 */
public class Novexa {
    
    String name;
    String location;
    
    private Contract contract;

    public Novexa(String name, String location, Contract contract) {
        this.name = name;
        this.location = location;
        this.contract = contract;
    }

    public Novexa() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
