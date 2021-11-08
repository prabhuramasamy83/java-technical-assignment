package kata.supermarket.service;

import kata.supermarket.constant.ProductNames;
import kata.supermarket.model.Product;
import kata.supermarket.model.WeighedProduct;
import kata.supermarket.scale.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    private Basket basket = new BasketImpl(); //In Spring this could be autowired using @Autowired annotation

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        items.forEach(basket::addItem);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                //noItems(),
                //aSingleItemPricedPerUnit(),
                //multipleItemsPricedPerUnit(),
               // aSingleItemPricedByWeight(),
               // multipleItemsPricedByWeight(),
                buyOneGetOneFreeItemPricedPerUnit()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments buyOneGetOneFreeItemPricedPerUnit() {
        return Arguments.of("buy one and get one item free priced per unit", "4.66", Arrays.asList(aPackOfIceCream(), aPackOfIceCream(),aPackOfIceCream()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(ProductNames.Milk.name(), new BigDecimal("0.49")).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(ProductNames.Digestives.name(), new BigDecimal("1.55")).oneOf();
    }

    private static Item aPackOfIceCream() {
        return new Product(ProductNames.IceCream.name(), new BigDecimal("2.33")).oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(ProductNames.AmericanSweets.name(), new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(ProductNames.PickAndMix.name(), new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}