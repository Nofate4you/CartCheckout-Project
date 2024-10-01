package kevin.backend288.dao;

import kevin.backend288.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "carts", path = "carts") // Added RepositoryRestResource for REST endpoint
public interface CartRepository extends JpaRepository<Cart, Long> {
}

