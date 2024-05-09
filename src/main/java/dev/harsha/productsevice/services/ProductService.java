package dev.harsha.productsevice.services;

import dev.harsha.productsevice.models.Category;
import dev.harsha.productsevice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product getSingleProduct (long id);
    public List<Product> getAllproducts();
    public Product createProduct(String title, String description,
                                 String image, String category, double price);
    public List<Category> getAllCategoryProducts();
    public Product deleteSingleProduct(long id);
    public Product updateSingleProduct(long id);
    public List<Product> getProductsByCategory(String category);
}
