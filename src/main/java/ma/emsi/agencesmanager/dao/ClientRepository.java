package ma.emsi.agencesmanager.dao;

import ma.emsi.agencesmanager.Entities.Agence;
import ma.emsi.agencesmanager.Entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    public Page<Client> findByPrenomClientContains(String mc, Pageable pageable);
}
