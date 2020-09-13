package co.edu.javeriana.toures.product.repositories;

import co.edu.javeriana.toures.product.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
