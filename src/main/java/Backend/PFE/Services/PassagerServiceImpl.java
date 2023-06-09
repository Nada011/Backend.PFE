package Backend.PFE.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Passager;
import Backend.PFE.Repositories.PassagerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PassagerServiceImpl implements PassagerService {
	@Autowired
	private PassagerRepository PassagerRepository;
	@Override
	public List<Passager> getAllPassagers() {

		return PassagerRepository.findAll();
		
	}
	@Override
	public Passager addPassager(Passager Passager) {
		return PassagerRepository.save(Passager);
	}
}
