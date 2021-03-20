package de.leuphana.shop.connector.dto;

public class OrderPositionDTO {
    private Integer id;
    private Integer articleId;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
