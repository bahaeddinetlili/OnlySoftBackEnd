package com.onlysoft.gestion_production.controllers;

import com.onlysoft.gestion_production.entities.Article;
import com.onlysoft.gestion_production.exception.EntityNotFoundException;
import com.onlysoft.gestion_production.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    private final ArticleService articleService;

    private static final String UPLOAD_DIR = "C:/Users/bahae/OneDrive/Bureau/frontend/src/assets/img/";

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articleService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{id}/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> uploadImage(
            @PathVariable("id") Long articleId,
            @RequestParam("file") MultipartFile file) {
        try {
            articleService.saveImage(articleId, file);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Image uploaded successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error uploading image");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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
