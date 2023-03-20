package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Article;

public interface ArticleService {
	public Article updateArticle(Article article);

	public Article addArticle(Article article);

	public List<Article> getAllArticles();

	public void deleletArticle(Long id);
}
