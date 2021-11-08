package kata.supermarket.model;

import kata.supermarket.constant.ProductNames;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        Product product = new Product(ProductNames.Coffee.name(), price);
        assertEquals(price, product.oneOf().price());
    }
}