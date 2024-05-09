package dev.harsha.productsevice.productdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatepoductrequestDTO {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
