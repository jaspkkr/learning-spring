package com.jk.springelasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "articles")
public class Article {

    @Id
    private Long articleId;

    @Field(type = FieldType.Text)
    private String articleTitle;

    @Field(type = FieldType.Text)
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
