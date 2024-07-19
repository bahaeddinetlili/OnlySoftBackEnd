package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Optional<Article> findByCodeArticle(String codeArticle);

}
