package de.leuphana.shop.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import de.leuphana.shop.component.behaviour.CustomerServiceInvoker;
import de.leuphana.shop.component.behaviour.ShopServiceImplementation;
import de.leuphana.shop.component.behaviour.SupplierServiceInvoker;
import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.component.structure.PostAddress;
import de.leuphana.shop.connector.ShopRestConnector;

@TestMethodOrder(OrderAnnotation.class)
public class ShopServiceTest {
    private static CustomerServiceInvoker customerServiceInvoker;
    private static SupplierServiceInvoker supplierServiceInvoker;
    private static Article article;
    private static Customer customer;
    private static Order order;

    @BeforeAll
    static void beforeAll() {
        ShopRestConnector shopRestConnector = new ShopRestConnector();
        customerServiceInvoker = new ShopServiceImplementation(shopRestConnector);
        supplierServiceInvoker = new ShopServiceImplementation(shopRestConnector);

        customer = new Customer();
        customer.setFirstname("test");
        customer.setLastname("test");

        PostAddress postAddress = new PostAddress();
        postAddress.setStreet("");
        postAddress.setHousenumber("");
        postAddress.setZipcode("");
        postAddress.setCity("");

        customer.setPostAddress(postAddress);
    }

    @Test
    @org.junit.jupiter.api.Order(0)
    public void canUseBeAuthenticated() {
        supplierServiceInvoker.authenticate("test", "test");
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    public void canArticleBeCreated() {
        article = supplierServiceInvoker.createArticle("Clean Code", 50d);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void canArticlesBeSearched() {
        Assertions.assertNotNull(customerServiceInvoker.searchArticles(""));
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void canArticleBeFetched() {
        supplierServiceInvoker.getArticle(article.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void canArticleBeEdited() {
        article = supplierServiceInvoker.editArticle(article.getId(), "Dirty Code", 150d);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    public void canCartBeCreated() {
        customerServiceInvoker.createCart();
    }

    @Test
    @org.junit.jupiter.api.Order(6)
    public void canCartBeFetched() {
        Assertions.assertNotNull(customerServiceInvoker.getCart());
    }

    @Test
    @org.junit.jupiter.api.Order(7)
    public void canArticleBeAdded() {
        customerServiceInvoker.addArticleToCart(article.getId(), 420);
    }

    @Test
    @org.junit.jupiter.api.Order(8)
    public void canArticleBeRemoved() {
        customerServiceInvoker.removeArticleFromCart(article.getId());
        customerServiceInvoker.addArticleToCart(article.getId(), 420);
    }

    @Test
    @org.junit.jupiter.api.Order(9)
    public void canCartBeCheckOut() {
        order = customerServiceInvoker.checkoutCart(customer);
    }

    @Test
    @org.junit.jupiter.api.Order(10)
    public void canCustomerBeFetched() {
        customerServiceInvoker.getCustomer(order.getCustomer().getId());
    }

    @Test
    @org.junit.jupiter.api.Order(11)
    public void canOrderBeFetched() {
        customerServiceInvoker.getOrder(order.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(12)
    public void canOrdersBeFetched() {
        supplierServiceInvoker.getOrders();
    }
}
