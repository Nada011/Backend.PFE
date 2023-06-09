package Backend.PFE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BonPrestation")
public class BonPrestation implements Serializable  {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Boolean valide;

	@ManyToOne
	private Contrat contrat;
	@ManyToOne(fetch = FetchType.LAZY)
	private Retard retard;
	

	@ManyToOne(fetch = FetchType.LAZY)
	private Passager passager;
	@JsonBackReference(value="passager_bonPrestation")
	public Passager getPassager(){
		return this.passager;
	}
	@JsonBackReference(value="retard_bon")
	public Retard getRetard(){
		return this.retard;
	}
	public String getNomPassger(){
		return this.passager!=null?this.getPassager().getPAX():null;
	}
	public long getIdPassger(){
		return this.passager!=null?this.getPassager().getPassager_id():null;
	}
}
