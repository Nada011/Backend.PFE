package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Fournisseur;

public interface FournisseurService {
	public Fournisseur updateFournisseur(Fournisseur fournisseur);

	public Fournisseur addFournisseur(Fournisseur fournisseur);

	public List<Fournisseur> getAllFournisseurs();

	public void deleletFournisseur(Long id);
}
