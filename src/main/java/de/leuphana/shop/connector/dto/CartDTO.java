package de.leuphana.shop.connector.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private List<CartItemDTO> cartItems;
    private Integer id;

    public CartDTO() {
        this.cartItems = new ArrayList<CartItemDTO>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

}
