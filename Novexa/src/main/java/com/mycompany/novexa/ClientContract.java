/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novexa;

/**
 *
 * @author EstudianteLIS
 */
public class ClientContract {
    private String nameProject;
    private int duration;
    private double contractCost;
    private double comission;
    private Freelancer freelancer;
    private Client client;

    public ClientContract() {
    }

    public ClientContract(String nameProject, int duration, double contractCost, double comission, Freelancer freelancer, Client client) {
        this.nameProject = nameProject;
        this.duration = duration;
        this.contractCost = contractCost;
        this.comission = 0.1; // stablished comission
        this.freelancer = freelancer;
        this.client = client;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientContract{" + "nameProject=" + nameProject + ", duration=" + duration + ", comission=" + comission*100 +"%" + ", freelancer=" + freelancer + ", client=" + client + '}';
    }

    public double getContractCost() {
        return contractCost;
    }

    public void setContractCost(double contractCost) {
        this.contractCost = contractCost;
    }
}
