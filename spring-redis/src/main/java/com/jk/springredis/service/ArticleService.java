package com.jk.springredis.service;

import com.jk.springredis.model.Article;

import java.util.List;

public interface ArticleService {

    boolean saveArticle(Article article);
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    boolean deleteArticleById(Long id);
    boolean updateArticle(Long id, Article article);

}
