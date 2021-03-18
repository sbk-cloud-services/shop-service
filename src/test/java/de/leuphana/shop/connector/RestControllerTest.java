package de.leuphana.shop.connector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import de.leuphana.shop.component.structure.Cart;
import feign.Feign;
import feign.gson.GsonDecoder;
import de.leuphana.shop.component.structure.Article;

@TestMethodOrder(OrderAnnotation.class)
public class RestControllerTest {

    private static RestController restController;

    @BeforeAll
    static void setupBeforeClass() {
        restController = Feign.builder().decoder(new GsonDecoder()).target(RestController.class,
                "http://shop.localhost");
    }

    @Test
    public void canArticleBeSearched() {
        Assertions.assertTrue(restController.searchArticles("test").size() > 0);
    }

    @Test
    public void canCartBeCreated() {
        Cart cart = restController.createCart();
        Assertions.assertNotNull(cart);
    }

    @Test
    public void canCartBeFetched() {

        Cart cart = restController.createCart();

        Assertions.assertDoesNotThrow(() -> {

        });

        Assertions.assertNotNull(cart = restController.getCart(cart.getId()));
    }

    @Test
    public void canArticleBeAddedToCart() {
        Article article = new Article();

        article.setName("Test 123");
        article.setPrice(1.23);

        article = restController.createArticle(article);
        Integer cartId;
        Cart cart = restController.createCart();
        Assertions.assertNotNull(cartId = cart.getId());
        Assertions.assertNotNull(restController.addArticleToCart(article, cartId));
    }

    @Test
    public void canCartBeDeleted() {
        Assertions.fail("Lol, Kevin can be gotten.");
    }
}
