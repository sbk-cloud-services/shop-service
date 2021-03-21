package de.leuphana.shop.connector.mapper;

import java.util.LinkedList;
import java.util.List;

import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.component.structure.OrderPosition;
import de.leuphana.shop.connector.ShopRestConnector;
import de.leuphana.shop.connector.dto.OrderDTO;
import de.leuphana.shop.connector.dto.OrderPositionDTO;

public class OrderMapper {

    private static ShopRestConnector shopRestConnector;

    static {
        shopRestConnector = new ShopRestConnector();
    }

    public static Order mapOrderDTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();

        order.setCustomer(shopRestConnector.getCustomer(orderDTO.getCustomerId()));
        order.setId(orderDTO.getId());

        List<OrderPosition> orderPositions = new LinkedList<OrderPosition>();

        for (OrderPositionDTO orderPositionDTO : orderDTO.getOrderPositions()) {
            orderPositions.add(OrderPositionMapper.mapOrderPositionDTOtoOrderPosition(orderPositionDTO));

        }

        order.setOrderPositions(orderPositions);

        return order;
    }

    public static OrderDTO mapOrdertoOrderDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setId(order.getId());

        List<OrderPositionDTO> orderPositionsDTO = new LinkedList<OrderPositionDTO>();

        for (OrderPosition orderPosition : order.getOrderPositions()) {
            orderPositionsDTO.add(OrderPositionMapper.mapOrderPositionToOrderPositionDTO(orderPosition));
        }

        orderDTO.setOrderPositions(orderPositionsDTO);

        return orderDTO;
    }

}
