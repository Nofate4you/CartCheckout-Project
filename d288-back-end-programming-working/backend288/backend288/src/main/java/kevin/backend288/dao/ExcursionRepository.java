package kevin.backend288.dao;

import kevin.backend288.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "excursions", path = "excursions") // Added RepositoryRestResource for REST endpoint
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}

