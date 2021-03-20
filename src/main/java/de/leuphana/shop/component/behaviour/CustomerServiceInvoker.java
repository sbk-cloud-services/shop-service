package de.leuphana.shop.component.behaviour;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.Order;

public interface CustomerServiceInvoker {
    public List<Article> searchArticles(String searchQuery);

    public Article getArticle(Integer articleId);

    public Cart createCart();

    public Cart getCart();

    public void addArticleToCart(Integer articleId, Integer quantity);

    public void removeArticleFromCart(Integer articleId);

    public void checkoutCart();

    public Customer getCustomer(Integer customerId);

    public Order getOrder(Integer orderId);
}