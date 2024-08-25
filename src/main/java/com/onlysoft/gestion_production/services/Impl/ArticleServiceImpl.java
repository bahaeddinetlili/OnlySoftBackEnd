package com.onlysoft.gestion_production.services.Impl;

import com.onlysoft.gestion_production.entities.Article;
import com.onlysoft.gestion_production.exception.EntityNotFoundException;
import com.onlysoft.gestion_production.exception.ErrorCodes;
import com.onlysoft.gestion_production.repository.ArticleRepository;
import com.onlysoft.gestion_production.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private static final String UPLOAD_DIR = "C:/Users/bahae/OneDrive/Bureau/frontend/src/assets/img/";

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public void saveImage(Long articleId, MultipartFile file) throws IOException {
        // Validate the file and article ID
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // Create the directory if it does not exist
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save the file
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        file.transferTo(filePath.toFile());
    }

    @Override
    public Article save(Article article) {
        validateArticle(article); // Implement validation if needed
        return articleRepository.save(article);
    }

    @Override
    public Article findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        return articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public Article findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }
        return articleRepository.findByCodeArticle(codeArticle)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun article avec le code = " + codeArticle + " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }

    private void validateArticle(Article article) {
        // Implement validation logic if needed
    }
}
