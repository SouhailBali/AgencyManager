package ma.emsi.agencesmanager.dao;

import ma.emsi.agencesmanager.Entities.Agence;
import ma.emsi.agencesmanager.Entities.Societe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe,Long> {
    public Page<Societe> findByNomSocieteContains(String mc, Pageable pageable);
}
