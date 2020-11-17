package co.edu.javeriana.toures.product.services;

import co.edu.javeriana.toures.product.models.Product;
import co.edu.javeriana.toures.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        if(Objects.isNull(product)){
            throw new NullPointerException("The product is null");
        }

        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(Integer id){
        if(Objects.isNull(id)){
            throw new NullPointerException("The product id is null");
        }

        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        if(Objects.isNull(id)){
            throw new NullPointerException("The product id is null");
        }

        productRepository.deleteById(id);
    }

    public Product update(Integer id, Product product){
        if(Objects.isNull(product)){
            throw new NullPointerException("The product id is null");
        }

        Product productToUpdate = productRepository.findById(id).orElse(null);

        if(Objects.isNull(productToUpdate)){
            throw new NullPointerException("The product to update does not exist");
        }

        productToUpdate.setShowName(product.getShowName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setShowDate(product.getShowDate());
        productToUpdate.setOriginCity(product.getOriginCity());
        productToUpdate.setDestinationCity(product.getDestinationCity());
        productToUpdate.setArrivalDate(product.getArrivalDate());
        productToUpdate.setDepartureDate(product.getDepartureDate());
        productToUpdate.setCategory(product.getCategory());

        productToUpdate.setTransportType(product.getTransportType());
        productToUpdate.setTransportSupplier(product.getTransportSupplier());
        productToUpdate.setLodgingType(product.getLodgingType());
        productToUpdate.setLodgingSupplier(product.getLodgingSupplier());

        return productRepository.save(productToUpdate);
    }

}
