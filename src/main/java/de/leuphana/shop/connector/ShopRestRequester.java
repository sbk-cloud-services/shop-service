package de.leuphana.shop.connector;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import de.leuphana.shop.connector.dto.ArticleDTO;
import de.leuphana.shop.connector.dto.AuthenticationTokenDTO;
import de.leuphana.shop.connector.dto.CartDTO;
import de.leuphana.shop.connector.dto.CartItemDTO;
import de.leuphana.shop.connector.dto.CustomerDTO;
import de.leuphana.shop.connector.dto.EmailPasswordCredentialsDTO;
import de.leuphana.shop.connector.dto.OrderDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface ShopRestRequester {

    @RequestLine("GET /articles?searchQuery={searchQuery}")
    public List<ArticleDTO> searchArticles(@Param("searchQuery") String searchQuery);

    @RequestLine("POST /articles")
    public ArticleDTO createArticle(ArticleDTO article);

    @RequestLine("GET /articles/{id}")
    public ArticleDTO getArticle(@Param("id") Integer id);

    @RequestLine("POST /articles/{id}")
    public ArticleDTO editArticle(@Param("id") Integer id, ArticleDTO article);

    @RequestLine("DELETE /articles/{id}")
    public void deleteArticle(@Param("id") Integer id);

    @RequestLine("POST /carts")
    public CartDTO createCart();

    @RequestLine("GET /carts/{id}")
    public CartDTO getCart(@Param("id") Integer id);

    @RequestLine("POST /carts/{id}")
    public void addArticleToCart(CartItemDTO cartItem, @Param("id") Integer cartId);

    @RequestLine("POST /carts/{id}/articles/{articleId}")
    public void removeArticleFromCart(@Param("cartId") Integer cartId, @Param("articleId") Integer articleId);

    @RequestLine("DELETE /carts/{id}")
    public void deleteCart(@Param("id") Integer id);

    @RequestLine("POST /customers")
    public CustomerDTO createCustomer(CustomerDTO customer);

    @RequestLine("GET /customers/{id}")
    public CustomerDTO getCustomer(@Param("id") Integer id);

    @RequestLine("POST /orders")
    public OrderDTO createOrder(OrderDTO order);

    @RequestLine("GET /orders")
    public List<OrderDTO> getOrders();

    @RequestLine("GET /orders/{id}")
    public OrderDTO getOrder(@Param("id") Integer id);

    @RequestLine("POST /authentication/authenticate")
    public AuthenticationTokenDTO authenticateUser(@RequestBody EmailPasswordCredentialsDTO emailPasswordCredentials);

}
