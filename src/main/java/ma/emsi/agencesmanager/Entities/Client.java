package ma.emsi.agencesmanager.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nomClient;
    private String prenomClient;
    private static String  roleClient="CLIENT";
    private String passwordClient;
    private String emailClient;
    private String adresseClient;
    private int ageClient;
    @ManyToOne
    private Agence agenceClient;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getRoleClient() {
        return roleClient;
    }



    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public void setAgeClient(int ageClient) {
        this.ageClient = ageClient;
    }

    public Agence getAgenceClient() {
        return agenceClient;
    }

    public void setAgenceClient(Agence agenceClient) {
        this.agenceClient = agenceClient;
    }

    public Client(String nomClient, String prenomClient, String passwordClient, String emailClient, String adresseClient, int ageClient, Agence agenceClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.passwordClient = passwordClient;
        this.emailClient = emailClient;
        this.adresseClient = adresseClient;
        this.ageClient = ageClient;
        this.agenceClient = agenceClient;
    }

    public static void setRoleClient(String roleClient) {
        Client.roleClient = roleClient;
    }
}
