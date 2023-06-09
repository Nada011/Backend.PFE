package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Entities.Vol;

public interface VolService {


	public List<Vol> getAllVols();
	public Vol addVol(Vol vol);


}
