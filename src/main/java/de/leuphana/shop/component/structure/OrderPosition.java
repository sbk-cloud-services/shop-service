package de.leuphana.shop.component.structure;

public class OrderPosition {
    private Article article;
    private Integer quantity;

    public Article getArticleId() {
        return article;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setArticleId(Article article) {
        this.article = article;
    }
}
