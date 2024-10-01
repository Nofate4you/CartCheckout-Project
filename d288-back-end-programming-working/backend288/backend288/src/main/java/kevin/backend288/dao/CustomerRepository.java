package kevin.backend288.dao;

import kevin.backend288.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers") // Added RepositoryRestResource for REST endpoint
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


