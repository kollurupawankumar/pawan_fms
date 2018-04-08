package com.embassy.user.dao;

import java.util.List;

import com.embassy.user.dao.entity.Article;

public interface IArticleDAO {

	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

	boolean articleExists(String title, String category);

}
