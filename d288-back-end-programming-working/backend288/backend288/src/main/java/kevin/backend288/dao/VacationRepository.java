package kevin.backend288.dao;

import kevin.backend288.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "vacations", path = "vacations") // Added RepositoryRestResource for REST endpoint
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
