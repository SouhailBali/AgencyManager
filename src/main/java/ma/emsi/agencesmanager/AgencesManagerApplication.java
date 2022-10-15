package ma.emsi.agencesmanager;

import ma.emsi.agencesmanager.Entities.Agence;
import ma.emsi.agencesmanager.Entities.Societe;
import ma.emsi.agencesmanager.dao.AgenceRepository;
import ma.emsi.agencesmanager.dao.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgencesManagerApplication implements CommandLineRunner {
    @Autowired
private AgenceRepository agenceRepository;
    @Autowired
    private SocieteRepository societeRepository;
    public static void main(String[] args) {
        SpringApplication.run(AgencesManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
agenceRepository.save(new Agence("Bricoma","rabat/sale","053755448888","init"));
agenceRepository.save(new Agence("hyper","London","+3580058720","LG"));
agenceRepository.save(new Agence("Western","casablanca","05376654826","Union"));
agenceRepository.save(new Agence("WAFACASH","Rabat/Sale","+21257882965","CASH"));
*/
/*
        societeRepository.save(new Societe("Bricoma","rabat/sale","Bricoma@gmail.com","06557788441",58874));
        societeRepository.save(new Societe("Wafacash","Casablanca","Wafacash@gmail.com","+5886485284",10055488));
        societeRepository.save(new Societe("WesternUnion","Tanger","WesternUnion@gmail.com","0511488475",221511));
        societeRepository.save(new Societe("Tamwil","Agadir","Tamwil@gmail.com","05114495598",100000));

        societeRepository.save(new Societe("Bricoma","rabat/sale","Bricoma@gmail.com","06557788441",58874));
        societeRepository.save(new Societe("Wafacash","Casablanca","Wafacash@gmail.com","+5886485284",10055488));
        societeRepository.save(new Societe("WesternUnion","Tanger","WesternUnion@gmail.com","0511488475",221511));
        societeRepository.save(new Societe("Tamwil","Agadir","Tamwil@gmail.com","05114495598",100000));
   */ }
}
