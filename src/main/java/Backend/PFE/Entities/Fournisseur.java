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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Fournisseur")
public class Fournisseur implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Nom;
	private int numTel;
	private int Fax;
	private String adresse;
	private int CodePostal;
	private String Ville;
	private String email;
	 
	
	@OneToMany(mappedBy="fournisseur", cascade = CascadeType.ALL)
	private List<Contrat> contrats ;
	@JsonManagedReference(value="Contrat-Fournisseur")
	public List<Contrat> getContrats(){
		return this.contrats;
	}
	

}
