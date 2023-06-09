package Backend.PFE.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.BonPrestation;
import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Menu;
import Backend.PFE.Entities.Passager;
import Backend.PFE.Entities.Retard;
import Backend.PFE.Entities.Vol;
import Backend.PFE.Entities.addRetardRequest;
import Backend.PFE.Repositories.RetardRepository;
import Backend.PFE.Repositories.BonPrestationRepository;
import Backend.PFE.Repositories.VolRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RetardServiceImpl implements RetardService {
	@Autowired
	private RetardRepository RetardRepository;
	@Autowired
	private BonPrestationRepository BonPrestationRepository;
	@Autowired
	private VolRepository VolRepository;
	@Override
	public List<Retard> getAllRetards() {

		return RetardRepository.findAll();
		
	}
	@Override
	public Retard addRetard(addRetardRequest retardRequest) {
		
		Retard retard=new Retard();
		retard.setDateDeclanchement(retardRequest.getDateDeclanchement());
		retard.setVol(retardRequest.getVol());
		retard.setTypeRetard(retardRequest.getTypeRetard());
		RetardRepository.save(retard);
		
		
		List<Passager> passagers =retardRequest.getVol().getPassagers();
		for (Passager passager : passagers) {
			BonPrestation bon=new BonPrestation();
			bon.setValide(true);
			bon.setPassager(passager);
			bon.setRetard(retard);
			bon.setContrat(retardRequest.getContrat());
			BonPrestationRepository.save(bon);
		}
		

		
		return retard;
	}

}
