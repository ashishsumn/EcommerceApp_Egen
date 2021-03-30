package dev.ashish.egen.service;

import dev.ashish.egen.exceptions.ProductNotFoundException;
import dev.ashish.egen.model.Product;
import dev.ashish.egen.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public Product findProductByProductId(Long id) {
        return productRepo.findProductByProductId(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id " + id + " was not found"));
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductByProductId(id);
    }

}
