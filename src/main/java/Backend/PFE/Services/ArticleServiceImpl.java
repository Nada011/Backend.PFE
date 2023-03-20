package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Article;
import Backend.PFE.Repositories.ArticleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository ArticleRepository;

	@Override
	public List<Article> getAllArticles() {

		return ArticleRepository.findAll();
	}

	@Override
	public Article addArticle(Article article) {
		return ArticleRepository.save(article);
	}

	@Override
	public Article updateArticle(Article article) {
		Optional<Article> utOptional = ArticleRepository.findById(article.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return ArticleRepository.save(article);
		}
	}

	@Override
	public void deleletArticle(Long id) {
		ArticleRepository.deleteById(id);

	}

}
