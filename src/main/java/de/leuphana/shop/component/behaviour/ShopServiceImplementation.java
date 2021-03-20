package de.leuphana.shop.component.behaviour;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.Order;

public class ShopServiceImplementation implements SupplierServiceInvoker, CustomerServiceInvoker {

    @Override
    public List<Article> searchArticles(String searchQuery) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article getArticle(Integer articleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cart createCart() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cart getCart() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addArticleToCart(Integer articleId, Integer quantity) {
        // TODO Auto-generated method stub
    }

    @Override
    public void checkoutCart() {
        // TODO Auto-generated method stub
    }

    @Override
    public Order getOrder(Integer orderId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article createArticle(String name, Double price) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article editArticle(Integer articleId, String name, Double price) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteArticle(Integer articleId) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Order> getOrders() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void authenticate(String email, String password) {
        // TODO Auto-generated method stub
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeArticleFromCart(Integer articleId) {
        // TODO Auto-generated method stub

    }

}