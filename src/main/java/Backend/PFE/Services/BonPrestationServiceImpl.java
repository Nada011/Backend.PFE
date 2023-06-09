package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.BonPrestation;
import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Menu;
import Backend.PFE.Repositories.BonPrestationRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BonPrestationServiceImpl implements BonPrestationService  {
	@Autowired
	private BonPrestationRepository BonPrestationRepository;
	
	
	@Override
	public BonPrestation updateBonPrestation(BonPrestation BonPrestation) {
		Optional<BonPrestation> utOptional = BonPrestationRepository.findById(BonPrestation.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			
			return BonPrestationRepository.save(BonPrestation);
		}
	}
	@Override
	public BonPrestation updateValidite(BonPrestation bonPrestation) {
		Optional<BonPrestation> utOptional = BonPrestationRepository.findById(bonPrestation.getId());

	if(utOptional.isEmpty()) {return null;}
		else {	utOptional.get().setValide(false);
			return BonPrestationRepository.save(utOptional.get());}
		
	}
	@Override
	public BonPrestation addBonPrestation(BonPrestation BonPrestation) {
	

	return BonPrestationRepository.save(BonPrestation);
	}

	@Override
	public List<BonPrestation> getAllBonPrestation() {
	 
		return BonPrestationRepository.findAll();
	}

	@Override
	public void deleletBonPrestation(Long id) {
		BonPrestationRepository.deleteById(id);
		
	}

}
