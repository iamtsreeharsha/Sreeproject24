package dev.harsha.productsevice.productdto;

import dev.harsha.productsevice.models.Category;
import dev.harsha.productsevice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDTO {
        private Long id;
        private String title;
        private String image;
        private String description;
        private String category;
        private double price;

        public Product toProduct() {
                Product product = new Product();
                product.setId(getId());
                product.setTitle(getTitle());
                product.setDescription(getDescription());
                product.setImageUrl(getImage());

                Category category = new Category();
                category.setTitle(getCategory());
                product.setCategory(category);

                return product;
        }
}
