package sn.msae.sendmailservice.entity;

import org.springframework.stereotype.Component;


public class Information {

    private String nom;
    private String email;
    private String matricule;
    private String telephone;
    private String objet;
    private String message;

    public Information(String nom, String email, String matricule, String telephone, String objet, String message) {
        this.nom = nom;
        this.email = email;
        this.matricule = matricule;
        this.telephone = telephone;
        this.objet = objet;
        this.message = message;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
