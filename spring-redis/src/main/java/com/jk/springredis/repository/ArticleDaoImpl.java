package com.jk.springredis.repository;

import com.jk.springredis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{

    @Autowired
    RedisTemplate redisTemplate;

    private static String KEY = "ARTICLE";

    @Override
    public boolean saveArticle(Article article) {
//        redisTemplate.opsForValue().set(article.getArticleId().toString(), article);
    redisTemplate.opsForHash().put(KEY, article.getArticleId().toString(), article);
        return true;
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles;
        articles = redisTemplate.opsForHash().values(KEY);
        return articles;
    }

    @Override
    public Article getArticleById(Long id) {
        return (Article) redisTemplate.opsForHash().get(KEY, id.toString());
//        return (Article) redisTemplate.opsForValue().get(id.toString());
    }

    @Override
    public boolean deleteArticleById(Long id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
        return true;
    }

    @Override
    public boolean updateArticle(Long id, Article article) {
        redisTemplate.opsForHash().put(KEY, id.toString(), article);
        return true;
    }
}
