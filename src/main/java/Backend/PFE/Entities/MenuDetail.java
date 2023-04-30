package Backend.PFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MenuDetail")
public class MenuDetail implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double prix;
	@ManyToOne(fetch = FetchType.LAZY)
	private Article article;
	@ManyToOne(fetch = FetchType.LAZY)
	private Menu menu;
	@JsonBackReference(value="Menu_Detail")
	public Menu getMenu(){
		return this.menu;
	}
	@JsonBackReference(value="article_Detail")
	public Article getArticle(){
		return this.article;
	}
	public String getNomArticleFr(){
		return this.article.getNomArticleFr();
	}
	public String getNomArticleAr(){
		return this.article.getNomArticleAr();
	}
	public String getNomArticleEn(){
		return this.article.getNomArticleEn();
	}
	public double getIdArticle(){
		return this.article.getId();
	}
	public double getIdMenu(){
		return this.menu.getId();
	}
}
