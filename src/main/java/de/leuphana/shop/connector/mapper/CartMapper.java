package de.leuphana.shop.connector.mapper;

import java.util.LinkedList;
import java.util.List;

import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.CartItem;
import de.leuphana.shop.connector.dto.CartDTO;
import de.leuphana.shop.connector.dto.CartItemDTO;

public class CartMapper {

    public static Cart mapCartDTOtoCart(CartDTO cartDTO) {

        Cart cart = new Cart();

        List<CartItem> cartItems = new LinkedList<>();

        for (CartItemDTO cartItemDTO : cartDTO.getCartItems()) {
            cartItems.add(CartItemMapper.mapCartItemDTOtoCartItem(cartItemDTO));

        }

        cart.setCartItems(cartItems);
        cart.setId(cartDTO.getId());

        return cart;

    }

}
