package Backend.PFE.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contrat")
public class Contrat implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-dd-MM")
	private Date dateDebut;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-dd-MM")	
	private Date dateFin;
	
	@OneToOne
	private  Menu Menu;
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
	@JsonBackReference(value="Contrat-Fournisseur")

	public Fournisseur getFournisseur(){
		return this.fournisseur;
	}


	public Long getFournisseurId() {
		return fournisseur!=null?this.getFournisseur().getId():null;
	}
	public String getFournisseurNom() {
		return fournisseur!=null?this.getFournisseur().getNom():null;
	}
	
	
	
}
