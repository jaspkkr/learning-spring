package com.jk.springelasticsearch.service;

import com.jk.springelasticsearch.model.Article;
import com.jk.springelasticsearch.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id.toString());
        if (article.isPresent()){
            return article.get();
        }else {
            throw new ResourceNotFoundException("Article not found with id: " + id);
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
            savedArticle.setArticleTitle(article.getArticleTitle());
            savedArticle.setArticleText(article.getArticleText());
            return articleRepository.save(savedArticle);
        }else {
            throw new ResourceNotFoundException("Article not found with id " + id);
        }
    }
}
