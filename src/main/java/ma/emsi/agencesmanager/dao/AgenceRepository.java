package ma.emsi.agencesmanager.dao;

import ma.emsi.agencesmanager.Entities.Agence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence, Long > {
public Page<Agence> findByTitleAgenceContains(String mc, Pageable pageable);
public List<Agence> findAll();
public Page<Agence> findAllBySocieteAgence(Long idSoc,Pageable pageable);
}
