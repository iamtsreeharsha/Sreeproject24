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
public class FakeStoreCategoryDTO {
    private String title;

    public Category toCategory() {
        Category category = new Category();
        category.setTitle(getTitle());
        return category;
    }
}
