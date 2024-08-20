package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        return Article.builder()
                .id(articleDto.getId())
                .codeArticle(articleDto.getCodeArticle())
                .prixUnitaireHt(articleDto.getPrixUnitaireHt())
                .tauxTva(articleDto.getTauxTva())
                .prixUnitaireTtc(articleDto.getPrixUnitaireTtc())
                .category(CategoryDto.toEntity(articleDto.getCategory()))
                .build();
    }
}
