package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Fournisseur;

public interface ContratService {
	public Contrat updateContrat(Contrat Contrat);

	public Contrat addContrat(Contrat Contrat);

	public List<Contrat> getAllContrats();

	public void deleletContrat(Long id);
	public Fournisseur getFournisseur(Long id);
}