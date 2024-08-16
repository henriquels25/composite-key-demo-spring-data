package io.henriquels25.demo.compositekey.repository;
import io.henriquels25.demo.compositekey.model.Customer;
import io.henriquels25.demo.compositekey.model.Product;
import io.henriquels25.demo.compositekey.model.ProductRating;
import io.henriquels25.demo.compositekey.model.ProductRatingId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRatingRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRatingRepository productRatingRepository;

    @Test
    public void testCreateProductRating() {
        // Create and save a Product
        Product product = Product.builder()
                .name("Test Product")
                .build();
        product = productRepository.save(product);

        // Create and save a Customer
        Customer customer = Customer.builder()
                .name("Test Customer")
                .build();
        customer = customerRepository.save(customer);

        // Create a ProductRating
//        ProductRatingId productRatingId = new ProductRatingId(customer.getId(), product.getId());
        ProductRating productRating = ProductRating.builder()
                .id(new ProductRatingId())
                .customer(customer)
                .product(product)
                .rating(10)
                .build();

        productRatingRepository.save(productRating);

        // Fetch the saved rating
        // ProductRating foundRating = productRatingRepository.findById(new ProductRatingId(customer.getId(), product.getId())).orElse(null);

        // Assert that the rating is saved correctly
        assertThat(productRating).isNotNull();
        assertThat(productRating.getId().getProductId()).isNotNull();
        assertThat(productRating.getId().getCustomerId()).isNotNull();
        assertThat(productRating.getRating()).isEqualTo(10);
        assertThat(productRating.getCustomer().getName()).isEqualTo("Test Customer");
        assertThat(productRating.getProduct().getName()).isEqualTo("Test Product");
    }
}
