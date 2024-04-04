package com.jk.springrediselasticsearch.controller;

import com.jk.springrediselasticsearch.model.Article;
import com.jk.springrediselasticsearch.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/article")
    public ResponseEntity<Article> saveArticle(@RequestBody Article Article){
        Article article = articleService.saveArticle(Article);
        return ResponseEntity.ok(article);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> FindArticleByIdArticle(@PathVariable("id") Long id){
        Article article = articleService.getArticleById(id);
        if(article != null) {
            return ResponseEntity.ok(article);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<HttpStatus> deleteArticleByIdArticle(@PathVariable("id") Long id){
        articleService.deleteArticleById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<Article> updateArticleByIdArticle(@PathVariable("id") Long id, @RequestBody Article article){
        Article savedArticle = articleService.updateArticle(id, article);
        return ResponseEntity.ok(savedArticle);
    }

}
