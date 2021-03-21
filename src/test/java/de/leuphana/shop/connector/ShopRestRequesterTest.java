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
import de.leuphana.shop.connector.dto.CartItemDTO;
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
    private static ArticleDTO articleDTO;
    private static CartDTO cartDTO;
    private static CartItemDTO cartItemDTO;
    private static CustomerDTO customerDTO;
    private static OrderDTO orderDTO;
    private static EmailPasswordCredentialsDTO emailPasswordCredentialsDTO;

    @BeforeAll
    static void setupBeforeClass() {
        shopRestRequester = Feign.builder().requestInterceptor(new ShopRestRequesterIntercepter())
                .encoder(new GsonEncoder()).decoder(new ShopRestDecoder())
                .target(ShopRestRequester.class, "http://localhost");

        // email and password credentials
        emailPasswordCredentialsDTO = new EmailPasswordCredentialsDTO();
        emailPasswordCredentialsDTO.setEmail("test");
        emailPasswordCredentialsDTO.setPassword("test");

        // article
        articleDTO = new ArticleDTO();
        articleDTO.setName("Test 123");
        articleDTO.setPrice(1.23);

        // customer
        customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jane");
        customerDTO.setLastname("Dane");

        PostAddressDTO postAddressDTO = new PostAddressDTO();
        postAddressDTO.setStreet("My Street");
        postAddressDTO.setHousenumber("132a");
        postAddressDTO.setZipcode("00001");
        postAddressDTO.setCity("Whatevers");
        customerDTO.setPostAddress(postAddressDTO);

        // Cart item
        cartItemDTO = new CartItemDTO();
        cartItemDTO.setQuantity(3);

        // order and order positions
        orderDTO = new OrderDTO();

        List<OrderPositionDTO> orderPositions = new ArrayList<>();

        OrderPositionDTO orderPosition = new OrderPositionDTO();
        orderPosition.setArticleId(articleDTO.getId());
        orderPosition.setQuantity(3);
        orderPositions.add(orderPosition);

        orderDTO.setOrderPositions(orderPositions);
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    public void canUserBeAuthenticated() {
        shopRestRequester.authenticateUser(emailPasswordCredentialsDTO);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void canArticleBeCreated() {
        articleDTO = shopRestRequester.createArticle(articleDTO);
        Assertions.assertNotNull(articleDTO);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void canArticleBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getArticle(articleDTO.getId()));
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void canArticlesBeSearched() {
        Assertions.assertTrue(shopRestRequester.searchArticles(articleDTO.getName()).size() > 0);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    public void canArticleBeEdited() {
        articleDTO.setName("This is an updated article");
        articleDTO.setPrice(13.37);

        Assertions.assertNotNull(shopRestRequester.editArticle(articleDTO.getId(), articleDTO));
    }

    @Test
    @org.junit.jupiter.api.Order(6)
    public void canCartBeCreated() {
        cartDTO = shopRestRequester.createCart();
        Assertions.assertNotNull(cartDTO);
    }

    @Test
    @org.junit.jupiter.api.Order(7)
    public void canCartBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getCart(cartDTO.getId()));
    }

    @Test
    @org.junit.jupiter.api.Order(8)
    public void canArticleBeAddedToCart() {
        cartItemDTO.setArticleId(articleDTO.getId());
        shopRestRequester.addArticleToCart(cartItemDTO, cartDTO.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(9)
    public void canCustomerBeCreated() {
        customerDTO = shopRestRequester.createCustomer(customerDTO);
        Assertions.assertNotNull(customerDTO);
    }

    @Test
    @org.junit.jupiter.api.Order(10)
    public void canCustomerBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getCustomer(customerDTO.getId()));
    }

    @Test
    @org.junit.jupiter.api.Order(11)
    public void canOrderBeCreated() {
        orderDTO.setCustomerId(customerDTO.getId());
        orderDTO.getOrderPositions().get(0).setArticleId(articleDTO.getId());

        orderDTO = shopRestRequester.createOrder(orderDTO);
        Assertions.assertNotNull(orderDTO);
    }

    @Test
    @org.junit.jupiter.api.Order(12)
    public void canOrderBeFetched() {
        Assertions.assertNotNull(shopRestRequester.getOrder(orderDTO.getId()));
    }

    @Test
    @org.junit.jupiter.api.Order(13)
    public void canOrdersBeFetched() {
        Assertions.assertTrue(shopRestRequester.getOrders().size() > 0);
    }

    @Test
    @org.junit.jupiter.api.Order(14)
    public void canArticleBeRemoved() {
        shopRestRequester.removeArticleFromCart(cartDTO.getId(), articleDTO.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(15)
    public void canCartBeDeleted() {
        shopRestRequester.deleteCart(cartDTO.getId());
    }
}
