package io.henriquels25.demo.compositekey.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRatingId implements Serializable {

    private Long customerId;
    private Long productId;
}
