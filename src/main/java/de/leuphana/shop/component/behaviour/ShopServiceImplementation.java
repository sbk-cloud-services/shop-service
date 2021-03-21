package de.leuphana.shop.component.behaviour;

import java.util.ArrayList;
import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.CartItem;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.EmailPasswordCredentials;
import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.component.structure.OrderPosition;
import de.leuphana.shop.connector.ShopRestConnector;

public class ShopServiceImplementation implements SupplierServiceInvoker, CustomerServiceInvoker {

    private ShopRestConnector shopRestConnector;
    private Cart cart;

    public ShopServiceImplementation(ShopRestConnector shopRestConnector) {
        this.shopRestConnector = shopRestConnector;
    }

    @Override
    public List<Article> searchArticles(String searchQuery) {
        return shopRestConnector.searchArticles(searchQuery);
    }

    @Override
    public Article getArticle(Integer articleId) {
        return shopRestConnector.getArticle(articleId);
    }

    @Override
    public Cart createCart() {
        cart = shopRestConnector.createCart();
        return cart;
    }

    @Override
    public Cart getCart() {
        return shopRestConnector.getCart(cart.getId());
    }

    @Override
    public void addArticleToCart(Integer articleId, Integer quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setArticle(shopRestConnector.getArticle(articleId));
        cartItem.setQuantity(quantity);

        cart.getCartItems().add(cartItem);

        shopRestConnector.addArticleToCart(cartItem, cart.getId());
    }

    @Override
    public Order checkoutCart(Customer customer) {
        customer = shopRestConnector.createCustomer(customer);

        Order order = new Order();
        List<OrderPosition> orderPositions = new ArrayList<OrderPosition>();

        Cart cart = this.getCart();

        cart.getCartItems().forEach((cartItem) -> {
            OrderPosition orderPosition = new OrderPosition();
            orderPosition.setArticle(cartItem.getArticle());
            orderPosition.setQuantity(cartItem.getQuantity());

            orderPositions.add(orderPosition);
        });

        order.setCustomer(customer);
        order.setOrderPositions(orderPositions);

        order = shopRestConnector.createOrder(order);
        shopRestConnector.deleteCart(cart.getId());
        cart = this.createCart();

        return order;
    }

    @Override
    public Order getOrder(Integer orderId) {
        return shopRestConnector.getOrder(orderId);
    }

    @Override
    public Article createArticle(String name, Double price) {
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);

        return shopRestConnector.createArticle(article);
    }

    @Override
    public Article editArticle(Integer articleId, String name, Double price) {
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);

        return shopRestConnector.editArticle(articleId, article);
    }

    @Override
    public List<Order> getOrders() {
        return shopRestConnector.getOrders();
    }

    @Override
    public void authenticate(String email, String password) {
        EmailPasswordCredentials emailPasswordCredentials = new EmailPasswordCredentials();
        emailPasswordCredentials.setEmail(email);
        emailPasswordCredentials.setPassword(password);

        shopRestConnector.authenticateUser(emailPasswordCredentials);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return shopRestConnector.getCustomer(customerId);
    }

    @Override
    public void removeArticleFromCart(Integer articleId) {
        shopRestConnector.removeArticleFromCart(cart.getId(), articleId);
    }

}