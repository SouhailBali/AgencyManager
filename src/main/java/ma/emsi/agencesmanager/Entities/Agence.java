package ma.emsi.agencesmanager.Entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Entity
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

@Column(nullable = false,length = 50)
    private String titleAgence;

    private String adresseAgence;

    private String telAgence;
@OneToMany(mappedBy = "agenceClient")
    private List<Client> clientslist;
@ManyToOne
private Societe societeAgence;
    private String startCapAgence;

    public Agence() {
    }

    public Long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Long idAgence) {
        this.idAgence = idAgence;
    }

    public String getTitleAgence() {
        return titleAgence;
    }

    public void setTitleAgence(String titleAgence) {
        this.titleAgence = titleAgence;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public String getTelAgence() {
        return telAgence;
    }

    public void setTelAgence(String telAgence) {
        this.telAgence = telAgence;
    }

    public List<Client> getClientslist() {
        return clientslist;
    }

    public void setClientslist(List<Client> clientslist) {
        this.clientslist = clientslist;
    }

    public Societe getSocieteAgence() {
        return societeAgence;
    }

    public void setSocieteAgence(Societe societeAgence) {
        this.societeAgence = societeAgence;
    }

    public String getStartCapAgence() {
        return startCapAgence;
    }

    public void setStartCapAgence(String startCapAgence) {
        this.startCapAgence = startCapAgence;
    }

    public Agence(String titleAgence, String adresseAgence, String telAgence, List<Client> clientslist, Societe societeAgence, String startCapAgence) {
        this.titleAgence = titleAgence;
        this.adresseAgence = adresseAgence;
        this.telAgence = telAgence;
        this.clientslist = clientslist;
        this.societeAgence = societeAgence;
        this.startCapAgence = startCapAgence;
    }
}
