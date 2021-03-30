package dev.ashish.egen.repo;

import dev.ashish.egen.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    void deleteProductByProductId(Long product_id);

    Optional<Product> findProductByProductId(Long product_id);
}
