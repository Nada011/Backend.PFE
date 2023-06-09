package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Fournisseur;
import Backend.PFE.Entities.Menu;
import Backend.PFE.Repositories.ContratRepository;
import Backend.PFE.Repositories.MenuRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContratServiceImpl implements ContratService {
	@Autowired
	private ContratRepository ContratRepository;
	@Autowired
	private MenuRepository MenuRepository;
	
	@Override
	public Contrat updateContrat(Contrat Contrat) {
		Optional<Contrat> utOptional = ContratRepository.findById(Contrat.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			Menu menu=Contrat.getMenu();
			MenuRepository.save(menu);
			return ContratRepository.save(Contrat);
		}
	}

	@Override
	public Contrat addContrat(Contrat Contrat) {
	
	Menu menu =Contrat.getMenu();
	MenuRepository.save(menu);
	return ContratRepository.save(Contrat);
	}

	@Override
	public List<Contrat> getAllContrats() {
	 
		return ContratRepository.findAll();
	}

	@Override
	public void deleletContrat(Long id) {
		ContratRepository.deleteById(id);
		
	}



}
