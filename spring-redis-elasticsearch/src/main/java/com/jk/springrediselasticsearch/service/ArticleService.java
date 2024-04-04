package com.jk.springrediselasticsearch.service;

import com.jk.springrediselasticsearch.model.Article;

public interface ArticleService {

    Article saveArticle(Article article);
    Article getArticleById(Long id);
    void deleteArticleById(Long id);
    Article updateArticle(Long id, Article article);

}
