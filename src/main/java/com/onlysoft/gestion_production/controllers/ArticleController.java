package com.onlysoft.gestion_production.controllers;

import com.onlysoft.gestion_production.entities.Article;
import com.onlysoft.gestion_production.exception.EntityNotFoundException;
import com.onlysoft.gestion_production.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.findAll();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
        try {
            Article article = articleService.findById(id);
            return ResponseEntity.ok(article);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articleService.save(article);
        return ResponseEntity.status(201).body(savedArticle);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Article> updateArticle(@PathVariable Integer id, @RequestBody Article article) {
        try {
            Article existingArticle = articleService.findById(id);
            article.setId(existingArticle.getId());
            Article updatedArticle = articleService.save(article);
            return ResponseEntity.ok(updatedArticle);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer id) {
        try {
            articleService.findById(id);
            articleService.delete(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
