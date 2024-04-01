package com.jk.springredis.service;

import com.jk.springredis.model.Article;
import com.jk.springredis.repository.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleDao articleDao;

    @Override
    public boolean saveArticle(Article article) {
        return articleDao.saveArticle(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public boolean deleteArticleById(Long id) {
        return articleDao.deleteArticleById(id);
    }

    @Override
    public boolean updateArticle(Long id, Article article) {
        return articleDao.updateArticle(id, article);
    }
}
