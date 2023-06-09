package Backend.PFE.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passager")
public class Passager implements Serializable {
	@Id
	@Column(name = "Passager_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Passager_id;
	private String PAX;
	private char ENFANT;
	private String PARTIE;
	private int ORDRE;
	@OneToMany(mappedBy="passager",cascade = CascadeType.ALL)
	private List<BonPrestation> bonsPrestation ;
	@JsonManagedReference(value="passager_bonPrestation")
	public List<BonPrestation> getbonsPrestation(){
		return this.bonsPrestation;
	}
@ManyToMany
private List<Vol>vols;
}
