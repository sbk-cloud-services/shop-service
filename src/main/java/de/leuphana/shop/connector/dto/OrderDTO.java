package de.leuphana.shop.connector.dto;

import java.util.List;

public class OrderDTO {

    private Integer orderId;
    private List<OrderPositionDTO> orderPositions;
    private Integer customerId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<OrderPositionDTO> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPositionDTO> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
