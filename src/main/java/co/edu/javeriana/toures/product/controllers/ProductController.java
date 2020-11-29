package co.edu.javeriana.toures.product.controllers;

import co.edu.javeriana.toures.product.models.Product;
import co.edu.javeriana.toures.product.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> get() {
        return productService.listProducts();
    }

    @PostMapping
    public Product post(@RequestBody Product product){

        try {

            return productService.createProduct(product);

        }catch (NullPointerException ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        }catch (Exception ex){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);

        }
    }

    @GetMapping("{id}")
    public Product get(@PathVariable Integer id){

        try {

            return productService.findById(id);

        }catch (NullPointerException ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        }catch (Exception ex){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);

        }
    }

    @GetMapping("findAllByIds/{ids}")
    public List<Product> getByIds(@PathVariable Integer[] ids){

        try {

            return productService.findAllById(ids);

        }catch (NullPointerException ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        }catch (Exception ex){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);

        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id ){

        try {

            productService.deleteById(id);

        }catch (NullPointerException ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        }catch (Exception ex){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PutMapping("{id}")
    public Product put(@PathVariable Integer id,@RequestBody Product product){

        try {

            return productService.update(id, product);

        }catch (NullPointerException ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        }catch (Exception ex){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
