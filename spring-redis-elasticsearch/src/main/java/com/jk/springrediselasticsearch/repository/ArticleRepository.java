package com.jk.springrediselasticsearch.repository;

import com.jk.springrediselasticsearch.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

//
//    boolean saveArticle(Article article);
//    List<Article> getAllArticles();
//    Article getArticleById(Long id);
//    boolean deleteArticleById(Long id);
//    boolean updateArticle(Long id, Article article);
}
