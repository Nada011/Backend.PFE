package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.Article;
import Backend.PFE.Entities.Fournisseur;
import Backend.PFE.Services.ArticleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class ArticleController {
	@Autowired
	private ArticleService ArticleService;

	@GetMapping("/articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		return ResponseEntity.ok().body(ArticleService.getAllArticles());
	}

	@PutMapping("article/update")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		return ResponseEntity.ok().body(ArticleService.updateArticle(article));
	}

	@PostMapping("article/add")
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		URI uri = URI
				.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/article/add").toUriString());
		return ResponseEntity.created(uri).body(ArticleService.addArticle(article));
	}

	@DeleteMapping("article/delete/{id}")
	public void deleteArticle(@PathVariable("id") Long id) {

		ArticleService.deleletArticle(id);
	}

}
