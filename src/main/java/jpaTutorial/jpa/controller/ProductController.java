package jpaTutorial.jpa.controller;

import jpaTutorial.jpa.entities.ProductEntity;
import jpaTutorial.jpa.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
        return productRepository.findBy(Sort.by(sortBy));
    }

}
