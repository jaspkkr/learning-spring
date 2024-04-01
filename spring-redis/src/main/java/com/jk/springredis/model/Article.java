package com.jk.springredis.model;

import java.io.Serializable;

public class Article implements Serializable {

    private static final Long serialUID = 1940088823639072035L;

    private Long articleId;
    private String articleTitle;
    private String articleText;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "{" +
                "articleId:" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleText='" + articleText + '\'' +
                '}';
    }
}
