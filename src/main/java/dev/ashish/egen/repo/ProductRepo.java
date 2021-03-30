package dev.ashish.egen.repo;

import dev.ashish.egen.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
