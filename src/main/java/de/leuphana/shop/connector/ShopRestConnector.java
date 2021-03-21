package de.leuphana.shop.connector;

import java.util.ArrayList;
import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.CartItem;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.EmailPasswordCredentials;
import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.connector.dto.ArticleDTO;
import de.leuphana.shop.connector.dto.OrderDTO;
import de.leuphana.shop.connector.mapper.ArticleMapper;
import de.leuphana.shop.connector.mapper.CartItemMapper;
import de.leuphana.shop.connector.mapper.CartMapper;
import de.leuphana.shop.connector.mapper.CustomerMapper;
import de.leuphana.shop.connector.mapper.EmailPasswordCredentialsMapper;
import de.leuphana.shop.connector.mapper.OrderMapper;
import feign.Feign;
import feign.gson.GsonEncoder;

public class ShopRestConnector {

    private ShopRestRequester shopRestRequester;

    public ShopRestConnector() {
        shopRestRequester = Feign.builder().requestInterceptor(new ShopRestRequesterIntercepter())
                .encoder(new GsonEncoder()).decoder(new ShopRestDecoder())
                .target(ShopRestRequester.class, "http://localhost");
    }

    public List<Article> searchArticles(String searchQuery) {
        List<ArticleDTO> articleDTOs = shopRestRequester.searchArticles(searchQuery);
        List<Article> articles = new ArrayList<Article>();

        articleDTOs.stream().forEach((articleDTO) -> {
            articles.add(ArticleMapper.mapArticleDTOtoArticle(articleDTO));
        });

        return articles;
    }

    public Article createArticle(Article article) {
        ArticleDTO articleDTO = ArticleMapper.mapArticletoArticleDTO(article);
        articleDTO = shopRestRequester.createArticle(articleDTO);
        return ArticleMapper.mapArticleDTOtoArticle(articleDTO);
    }

    public Article getArticle(Integer id) {
        return ArticleMapper.mapArticleDTOtoArticle(shopRestRequester.getArticle(id));
    }

    public Article editArticle(Integer id, Article article) {
        return ArticleMapper.mapArticleDTOtoArticle(
                shopRestRequester.editArticle(id, ArticleMapper.mapArticletoArticleDTO(article)));
    }

    public Cart createCart() {
        return CartMapper.mapCartDTOtoCart(shopRestRequester.createCart());
    }

    public Cart getCart(Integer id) {
        return CartMapper.mapCartDTOtoCart(shopRestRequester.getCart(id));
    }

    public void addArticleToCart(CartItem cartItem, Integer cartId) {
        shopRestRequester.addArticleToCart(CartItemMapper.mapCartItemtoCartItemDTO(cartItem), cartId);
    }

    public void removeArticleFromCart(Integer cartId, Integer articleId) {
        shopRestRequester.removeArticleFromCart(cartId, articleId);
    }

    public void deleteCart(Integer id) {
        shopRestRequester.deleteCart(id);
    }

    public Customer createCustomer(Customer customer) {
        return CustomerMapper.mapCustomerDTOtoCustomer(
                shopRestRequester.createCustomer(CustomerMapper.mapCustomertoCustomerDTO(customer)));
    }

    public Customer getCustomer(Integer id) {
        return CustomerMapper.mapCustomerDTOtoCustomer(shopRestRequester.getCustomer(id));
    }

    public Order createOrder(Order order) {
        return OrderMapper.mapOrderDTOtoOrder(shopRestRequester.createOrder(OrderMapper.mapOrdertoOrderDTO(order)));
    }

    public List<Order> getOrders() {
        List<OrderDTO> orderDTOs = shopRestRequester.getOrders();
        List<Order> orders = new ArrayList<Order>();

        orderDTOs.stream().forEach((orderDTO) -> {
            Order order = OrderMapper.mapOrderDTOtoOrder(orderDTO);
            orders.add(order);
        });

        return orders;
    }

    public Order getOrder(Integer id) {
        return OrderMapper.mapOrderDTOtoOrder(shopRestRequester.getOrder(id));
    }

    public void authenticateUser(EmailPasswordCredentials emailPasswordCredentials) {
        shopRestRequester.authenticateUser(EmailPasswordCredentialsMapper
                .mapEmailPasswordCredentialsToEmailPasswordCredentialsDTO(emailPasswordCredentials));
    }

}
