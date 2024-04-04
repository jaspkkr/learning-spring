package com.jk.springelasticsearch.service;

import com.jk.springelasticsearch.model.Article;

import java.util.List;

public interface ArticleService {

    Article saveArticle(Article article);
    Article getArticleById(Long id);
    void deleteArticleById(Long id);
    Article updateArticle(Long id, Article article);

}
