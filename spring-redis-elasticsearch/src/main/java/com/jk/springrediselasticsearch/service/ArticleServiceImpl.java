package com.jk.springrediselasticsearch.service;

import com.jk.springrediselasticsearch.model.Article;
import com.jk.springrediselasticsearch.repository.ArticleRepository;
import com.jk.springrediselasticsearch.util.WikipediaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    WikipediaUtil wikipediaUtil;

    private static String KEY = "ARTICLE";

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public void saveToRedis(Article article) {
        redisTemplate.opsForHash().put(KEY, article.getArticleId().toString(), article);
    }

    @Override
    public Article getArticleById(Long id) {
        Article art = (Article) redisTemplate.opsForHash().get(KEY, id.toString());
        if (art != null){
            return art;
        }else {
            Optional<Article> article = articleRepository.findById(id.toString());
            if (article.isPresent()) {
                saveToRedis(article.get());
                return article.get();
            } else {
                Article article1 = wikipediaUtil.getArticleFromWikipedia(id.toString());
                if (article1 == null){
                    return null;
                }else {
                    saveToRedis(article1);
                    articleRepository.save(article1);
                    return article1;
                }

            }
        }
    }

    @Override
    public void deleteArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id.toString());
        if (article.isPresent()) {
            articleRepository.deleteById(id.toString());
        } else {
            throw new ResourceNotFoundException("Article not found with id " + id);
        }
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        Optional<Article> existingArticle = articleRepository.findById(id.toString());
        if (existingArticle.isPresent()){
            Article savedArticle = existingArticle.get();
            savedArticle.setTitle(article.getTitle());
            savedArticle.setText(article.getText());
            return articleRepository.save(savedArticle);
        }else {
            throw new ResourceNotFoundException("Article not found with id " + id);
        }
    }
}
