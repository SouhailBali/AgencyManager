package ma.emsi.agencesmanager.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor

@Entity
public class Societe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSociete;
    private String nomSociete;
    private String adresseSociete;
    private String emailSociete;
    @OneToMany(mappedBy = "societeAgence")
    private List<Agence> agenceList;
    private String telSociete;
    private int valeurRisquesociete;

    public Societe() {
    }

    public Long getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Long idSociete) {
        this.idSociete = idSociete;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getAdresseSociete() {
        return adresseSociete;
    }

    public void setAdresseSociete(String adresseSociete) {
        this.adresseSociete = adresseSociete;
    }

    public String getEmailSociete() {
        return emailSociete;
    }

    public void setEmailSociete(String emailSociete) {
        this.emailSociete = emailSociete;
    }

    public List<Agence> getAgenceList() {
        return agenceList;
    }

    public void setAgenceList(List<Agence> agenceList) {
        this.agenceList = agenceList;
    }

    public String getTelSociete() {
        return telSociete;
    }

    public void setTelSociete(String telSociete) {
        this.telSociete = telSociete;
    }

    public int getValeurRisquesociete() {
        return valeurRisquesociete;
    }

    public void setValeurRisquesociete(int valeurRisquesociete) {
        this.valeurRisquesociete = valeurRisquesociete;
    }

    public Societe(String nomSociete, String adresseSociete, String emailSociete, List<Agence> agenceList, String telSociete, int valeurRisquesociete) {
        this.nomSociete = nomSociete;
        this.adresseSociete = adresseSociete;
        this.emailSociete = emailSociete;
        this.agenceList = agenceList;
        this.telSociete = telSociete;
        this.valeurRisquesociete = valeurRisquesociete;
    }
}
