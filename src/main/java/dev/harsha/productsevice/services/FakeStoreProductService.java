package dev.harsha.productsevice.services;

import dev.harsha.productsevice.models.Category;
import dev.harsha.productsevice.models.Product;
import dev.harsha.productsevice.productdto.FakeStoreCategoryDTO;
import dev.harsha.productsevice.productdto.FakeStoreProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(long id) {

        /*FakeStoreProductDTO fakeStoreProductDto =
                restTemplate.getForObject
                        ("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);*/

        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDto = responseEntity.getBody();

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product deleteSingleProduct(long id){
        /*FakeStoreProductDTO fakeStoreProductDto =
                restTemplate.getForObject
                        ("'https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);*/

        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDto = responseEntity.getBody();

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public List<Product> getAllproducts() {
        FakeStoreProductDTO[] response =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDto: response) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, String description,
                                 String image, String category, double price) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setTitle(title);

        FakeStoreProductDTO response = restTemplate
                .postForObject("https://fakestoreapi.com/products",
                        fakeStoreProductDTO,
                        FakeStoreProductDTO.class);
        return response.toProduct();
    }

    @Override
    public Product updateSingleProduct(long id){
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDto = responseEntity.getBody();

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public List<Category> getAllCategoryProducts () {
        FakeStoreCategoryDTO[] response =
                restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                        FakeStoreCategoryDTO[].class);

        List<Category> Categories = new ArrayList<>();
        for(FakeStoreCategoryDTO fakeStoreCategoryDTO: response) {
            Categories.add(fakeStoreCategoryDTO.toCategory());
        }
        return Categories;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDTO[] response = restTemplate
                .getForObject("https://fakestoreapi.com/products/category/" + category,
                        FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO dto : response) {
            products.add(dto.toProduct());
        }
        return products;
    }

    /*@Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDto[] response = restTemplate
                .getForObject("https://fakestoreapi.com/products/category/" + category,
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto dto : response) {
            products.add(dto.toProduct());
        }
        return products;
    }*/
}
