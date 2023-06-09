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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Retard")
public class Retard implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date dateDeclanchement;
	@ManyToOne
	private TypeRetard typeRetard;
	@OneToMany(mappedBy="retard",cascade = CascadeType.ALL)
	private List<BonPrestation> bonsPrestation ;
	
	
	@JsonManagedReference(value="retard_bon")
	public List<BonPrestation> getbonsPrestation(){
		return this.bonsPrestation;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vol vol;
	@JsonBackReference(value="Vol_Retards")

	public Vol getVol(){
		return this.vol;
	}
	
	public String getVL() {
		return this.vol.getVOL();
	}
	public Long getVLId() {
		return this.vol.getVOL_id();
	}
	public String getCIE() {
		return this.vol.getCIE();
	}
	public Date getDATE_VOL() {
		return this.vol.getDATE_VOL();
	}
	public String getORIGINE() {
		return this.vol.getORIGINE();
	}
	
	public String getDESTINATION() {
		return this.vol.getDESTINATION();
	}
	public int getNB_PAX() {
		return this.vol.getNB_PAX();
	}
	public int getNB_ENF() {
		return this.vol.getNB_ENF();
	}
	
}
