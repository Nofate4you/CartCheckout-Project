package kevin.backend288.dao;

import kevin.backend288.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "divisions", path = "divisions") // Added RepositoryRestResource for REST endpoint
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
