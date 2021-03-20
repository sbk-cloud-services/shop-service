package de.leuphana.shop.connector.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Integer id;
    private List<OrderPositionDTO> orderPositions;
    private Integer customerId;

    public OrderDTO() {
        this.orderPositions = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
