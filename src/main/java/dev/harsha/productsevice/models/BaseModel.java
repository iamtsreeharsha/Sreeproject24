package dev.harsha.productsevice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;
}
