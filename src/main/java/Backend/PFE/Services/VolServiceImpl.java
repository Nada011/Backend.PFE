package Backend.PFE.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Entities.Vol;
import Backend.PFE.Repositories.VolRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VolServiceImpl implements VolService{
	@Autowired
	private VolRepository VolRepository;
	@Override
	public List<Vol> getAllVols() {

		return VolRepository.findAll();
		
	}
	@Override
	public Vol addVol(Vol vol) {
		return VolRepository.save(vol);
	}
}
