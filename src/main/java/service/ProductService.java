package service;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void create(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product find(Long id){ return productRepository.getOne(id); }

    public void delete(Long id){ productRepository.deleteById(id); }

}
