package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Fournisseur;
import Backend.PFE.Repositories.FournisseurRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurRepository FournisseurRepository;

	@Override
	public List<Fournisseur> getAllFournisseurs() {

		return FournisseurRepository.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		return FournisseurRepository.save(fournisseur);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		Optional<Fournisseur> utOptional = FournisseurRepository.findById(fournisseur.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return FournisseurRepository.save(fournisseur);
		}
	}

	@Override
	public void deleletFournisseur(Long id) {
		FournisseurRepository.deleteById(id);

	}

}
