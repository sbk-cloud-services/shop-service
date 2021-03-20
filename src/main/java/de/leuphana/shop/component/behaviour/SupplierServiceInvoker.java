package de.leuphana.shop.component.behaviour;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Order;

public interface SupplierServiceInvoker {
    public List<Article> searchArticles(String searchQuery);

    public Article createArticle(String name, Double price);

    public Article editArticle(Integer articleId, String name, Double price);

    public void deleteArticle(Integer articleId);

    public Article getArticle(Integer articleId);

    public List<Order> getOrders();

    public Order getOrder(Integer orderId);

    public void authenticate(String email, String password);
}