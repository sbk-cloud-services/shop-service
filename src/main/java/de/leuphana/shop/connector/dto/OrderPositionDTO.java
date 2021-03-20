package de.leuphana.shop.connector.dto;

public class OrderPositionDTO {
    private Integer articleId;
    private Integer quantity;

    public Integer getArticleId() {
        return articleId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
