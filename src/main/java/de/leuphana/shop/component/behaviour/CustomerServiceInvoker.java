package de.leuphana.shop.component.behaviour;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.Order;

public interface CustomerServiceInvoker {
    public List<Article> searchArticles(String searchQuery);
    public Article getArticle(Integer articleId);

    public Cart createCart();
    public Cart getCart(Integer cartId);
    public void addArticleToCart(Integer cartId, Integer articleId); // TODO: Add quantity
    public void checkoutCart(Integer cartId);
    public Order getOrder(Integer orderId);
}