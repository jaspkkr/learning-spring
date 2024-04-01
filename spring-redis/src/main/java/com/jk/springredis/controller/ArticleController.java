package com.jk.springredis.controller;

import com.jk.springredis.model.Article;
import com.jk.springredis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/article")
    public ResponseEntity<String> saveArticle(@RequestBody Article Article){
        boolean articleSaved= articleService.saveArticle(Article);
        if(articleSaved) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/article")
    public ResponseEntity<List<Article>> getArticle(){
        List<Article> articleList = articleService.getAllArticles();
        if(articleList != null) {
            return ResponseEntity.ok(articleList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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

        boolean deleteArticleFlag= articleService.deleteArticleById(id);
        if(deleteArticleFlag) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<HttpStatus> updateArticleByIdArticle(@PathVariable("id") Long id,@RequestBody Article article){

        boolean updateArticleFlag= articleService.updateArticle(id, article);
        if(updateArticleFlag) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
