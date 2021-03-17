package de.leuphana.shop.component.behaviour;

import java.util.List;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.Order;

public class ShopImplementation implements SupplierServiceInvoker, CustomerServiceInvoker {

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
    public Cart getCart(Integer cartId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addArticleToCart(Integer cartId, Integer articleId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkoutCart(Integer cartId) {
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

} 