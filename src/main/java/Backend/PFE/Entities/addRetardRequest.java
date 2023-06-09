package Backend.PFE.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addRetardRequest {
	private TypeRetard typeRetard;
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date dateDeclanchement;
	private Vol vol;
	private Contrat contrat;
	
}
