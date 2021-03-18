package de.leuphana.shop.connector;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import feign.Param;
import feign.RequestLine;

public interface RestController {
    @RequestLine("GET /articles?searchQuery={searchQuery}")
    public List<Article> searchArticles(@Param("searchQuery") String searchQuery);

    @RequestLine("POST /carts")
    public Cart createCart();

    @RequestLine("GET /carts/{id}")
    public Cart getCart(@Param("id") Integer id);

    @RequestLine("POST /carts/{id}")
    public Object addArticleToCart(Article article, @Param("id") Integer cartId);

    @RequestLine("POST /articles")
    public Article createArticle(Article article);
}
