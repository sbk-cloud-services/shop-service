package de.leuphana.shop.connector;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import de.leuphana.shop.connector.dto.ArticleDTO;
import de.leuphana.shop.connector.dto.CartDTO;
import de.leuphana.shop.connector.dto.CustomerDTO;
import de.leuphana.shop.connector.dto.EmailPasswordCredentialsDTO;
import de.leuphana.shop.connector.dto.OrderDTO;
import de.leuphana.shop.connector.dto.OrderPositionDTO;
import de.leuphana.shop.connector.dto.PostAddressDTO;
import feign.Feign;
import feign.gson.GsonEncoder;

@TestMethodOrder(OrderAnnotation.class)
public class ShopRestRequesterTest {

    private static ShopRestRequester shopRestRequester;

    @BeforeAll
    static void setupBeforeClass() {
        shopRestRequester = Feign.builder().requestInterceptor(new ShopRestRequesterIntercepter())
                .encoder(new GsonEncoder()).decoder(new ShopRestDecoder())
                .target(ShopRestRequester.class, "http://shop.localhost");
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    public void canUserBeAuthenticated() {
        EmailPasswordCredentialsDTO emailPasswordCredentials = new EmailPasswordCredentialsDTO();
        emailPasswordCredentials.setEmail("test");
        emailPasswordCredentials.setPassword("test");

        shopRestRequester.authenticateUser(emailPasswordCredentials);
    }

    @Test
    public void canArticleBeCreated() {
        ArticleDTO article = new ArticleDTO();

        article.setName("Test 123");
        article.setPrice(1.23);

        Assertions.assertNotNull(shopRestRequester.createArticle(article));
    }

    @Test
    public void canArticleBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getArticle(1));
    }

    @Test
    public void canArticlesBeSearched() {
        Assertions.assertNotNull(shopRestRequester.searchArticles(""));
    }

    @Test
    public void canArticleBeEdited() {
        ArticleDTO article = new ArticleDTO();
        article.setName("This is an updated article");
        article.setPrice(13.37);

        Assertions.assertNotNull(shopRestRequester.editArticle(1, article));
    }

    @Test
    public void canArticleBeDeleted() {
        shopRestRequester.deleteArticle(1);
    }

    @Test
    public void canCartBeCreated() {
        Assertions.assertNotNull(shopRestRequester.createCart());
    }

    @Test
    public void canCartBeFetched() {
        CartDTO cart = shopRestRequester.createCart();
        Assertions.assertNotNull(cart = shopRestRequester.getCart(cart.getId()));
    }

    @Test
    public void canArticleBeAddedToCart() {
        ArticleDTO article = new ArticleDTO();

        article.setName("Test 123");
        article.setPrice(1.23);

        article = shopRestRequester.createArticle(article);
        CartDTO cart = shopRestRequester.createCart();

        Assertions.assertNotNull(cart);
        Assertions.assertNotNull(shopRestRequester.addArticleToCart(article, cart.getId()));
    }

    @Test
    public void canCartBeDeleted() {
        shopRestRequester.deleteCart(1);
    }

    @Test
    public void canCustomerBeCreated() {
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstname("Jane");
        customer.setLastname("Dane");

        PostAddressDTO postAddress = new PostAddressDTO();
        postAddress.setStreet("My Street");
        postAddress.setHousenumber("132a");
        postAddress.setZipcode("00001");
        postAddress.setCity("Whatevers");

        customer.setPostAddress(postAddress);

        Assertions.assertNotNull(shopRestRequester.createCustomer(customer));
    }

    @Test
    public void canCustomerBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getCustomer(1));
    }

    @Test
    public void canOrderBeCreated() {
        OrderDTO order = new OrderDTO();

        List<OrderPositionDTO> orderPositions = new ArrayList<>();

        OrderPositionDTO orderPosition = new OrderPositionDTO();
        orderPosition.setArticleId(1);
        orderPosition.setQuantity(3);

        orderPositions.add(orderPosition);

        order.setOrderPositions(orderPositions);
        order.setCustomerId(1);

        Assertions.assertNotNull(shopRestRequester.createOrder(order));
    }

    @Test
    public void canOrderBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getOrder(1));
    }

    @Test
    public void canOrdersBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getOrders());
    }
}
