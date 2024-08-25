package com.onlysoft.gestion_production.services;

import com.onlysoft.gestion_production.entities.Article;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleService {

    Article save(Article article);

    Article findById(Integer id);

    Article findByCodeArticle(String codeArticle);

    List<Article> findAll();

    void delete(Integer id);
    void saveImage(Long articleId, MultipartFile file) throws IOException;

}
