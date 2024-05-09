package dev.harsha.productsevice.controllers;

import dev.harsha.productsevice.models.Category;
import dev.harsha.productsevice.models.Product;
import dev.harsha.productsevice.productdto.CreatepoductrequestDTO;
import dev.harsha.productsevice.productdto.UpdateProductRequestDTO;
import dev.harsha.productsevice.services.FakeStoreProductService;
import dev.harsha.productsevice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductControllers {

    ProductService productService;

    public ProductControllers(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createproducts")
    public Product createProduct(@RequestBody CreatepoductrequestDTO productRequestDto) {
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImage(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
    }

    @PutMapping("/products/update/{id}")
    public Product updateSingleProduct(@PathVariable("id") long id){
        return productService.updateSingleProduct(id);
    }

    @GetMapping ("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> responseData = productService.getAllproducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));

        return responseEntity;
    }

    @GetMapping("/products/catergories")
    public ResponseEntity<List<Category>> getAllCatergories() {
        List<Category> responseData = productService.getAllCategoryProducts();

        ResponseEntity<List<Category>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));

        return responseEntity;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") long id) {
     return productService.getSingleProduct(id);
    }

    @DeleteMapping("/products/delete/{id}")
    public Product deleteProduct(@PathVariable("id") long id) {
        return productService.deleteSingleProduct(id);
    }

    /*@GetMapping("/products/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category){
        return productService.getProductsByCategory(category);
    }*/

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category){
        return productService.getProductsByCategory(category);
    }

}
