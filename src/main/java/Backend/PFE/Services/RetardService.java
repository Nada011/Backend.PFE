package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Retard;
import Backend.PFE.Entities.addRetardRequest;


public interface RetardService {

	public List<Retard> getAllRetards();
	
	Retard addRetard(addRetardRequest retard);

}
