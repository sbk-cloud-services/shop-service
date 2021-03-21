package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.connector.dto.ArticleDTO;

public class ArticleMapper {

    public static Article mapArticleDTOtoArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setName(articleDTO.getName());
        article.setPrice(articleDTO.getPrice());

        return article;
    }

    public static ArticleDTO mapArticletoArticleDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setName(article.getName());
        articleDTO.setPrice(article.getPrice());

        return articleDTO;
    }

}
