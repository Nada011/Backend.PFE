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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VOL")
public class Vol implements Serializable {
	@Id
	@Column(name = "VOL_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long VOL_id;
	private String VOL;
	private String CIE;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date DATE_VOL;
	private String ORIGINE;
	private String DESTINATION	;
	private int NB_PAX;
	private int NB_ENF;
	@ManyToMany( fetch = FetchType.EAGER)
	private List<Passager> Passagers;
	
	@OneToMany(mappedBy="vol", cascade = CascadeType.ALL)
	private List<Retard> retards ;
	@JsonManagedReference(value="Vol_Retards")
	public List<Retard> getRetards(){
		return this.retards;
	}

}
