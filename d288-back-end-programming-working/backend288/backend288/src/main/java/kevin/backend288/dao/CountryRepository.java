package kevin.backend288.dao;

import kevin.backend288.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries") // Added RepositoryRestResource for REST endpoint
public interface CountryRepository extends JpaRepository<Country, Long> {
}
