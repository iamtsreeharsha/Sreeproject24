package dev.harsha.productsevice.productdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdateProductRequestDTO {
        private long id;
        private String title;
        private String description;
        private String image;
        private String category;
        private double price;
    }
