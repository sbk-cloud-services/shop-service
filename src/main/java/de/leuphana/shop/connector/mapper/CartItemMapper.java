package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.CartItem;
import de.leuphana.shop.connector.ShopRestConnector;
import de.leuphana.shop.connector.dto.CartItemDTO;

public class CartItemMapper {
    private static ShopRestConnector shopRestConnector;

    static {
        shopRestConnector = new ShopRestConnector();
    }

    public static CartItem mapCartItemDTOtoCartItem(CartItemDTO cartItemDTO) {

        CartItem cartItem = new CartItem();

        cartItem.setArticle(shopRestConnector.getArticle(cartItemDTO.getArticleId()));
        cartItem.setId(cartItemDTO.getId());
        cartItem.setQuantity(cartItemDTO.getQuantity());

        return cartItem;

    }

    public static CartItemDTO mapCartItemtoCartItemDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setArticleId(cartItem.getArticle().getId());
        cartItemDTO.setId(cartItem.getId());
        cartItemDTO.setQuantity(cartItem.getQuantity());

        return cartItemDTO;
    }

}
