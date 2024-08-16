package io.henriquels25.demo.compositekey.repository;

import io.henriquels25.demo.compositekey.model.ProductRating;
import io.henriquels25.demo.compositekey.model.ProductRatingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository extends JpaRepository<ProductRating, ProductRatingId> {
}

