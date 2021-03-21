package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.OrderPosition;
import de.leuphana.shop.connector.ShopRestConnector;
import de.leuphana.shop.connector.dto.OrderPositionDTO;

public class OrderPositionMapper {

    private static ShopRestConnector shopRestConnector;

    static {

        shopRestConnector = new ShopRestConnector();

    }

    public static OrderPosition mapOrderPositionDTOtoOrderPosition(OrderPositionDTO orderPositionDTO) {

        OrderPosition orderPosition = new OrderPosition();

        orderPosition.setArticle(shopRestConnector.getArticle(orderPositionDTO.getArticleId()));
        orderPosition.setQuantity(orderPositionDTO.getQuantity());
        orderPosition.setId(orderPositionDTO.getId());

        return orderPosition;
    }

    public static OrderPositionDTO mapOrderPositionToOrderPositionDTO(OrderPosition orderPosition) {

        OrderPositionDTO orderPositionDTO = new OrderPositionDTO();

        orderPositionDTO.setArticleId(orderPosition.getArticle().getId());
        orderPositionDTO.setQuantity(orderPosition.getQuantity());
        orderPositionDTO.setId(orderPosition.getId());

        return orderPositionDTO;
    }

}
