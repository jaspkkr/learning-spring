package com.jk.springelasticsearch.repository;

import com.jk.springelasticsearch.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
//
//    boolean saveArticle(Article article);
//    List<Article> getAllArticles();
//    Article getArticleById(Long id);
//    boolean deleteArticleById(Long id);
//    boolean updateArticle(Long id, Article article);
}
