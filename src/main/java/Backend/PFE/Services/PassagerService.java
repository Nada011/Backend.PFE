package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Passager;
import Backend.PFE.Entities.Vol;

public interface PassagerService {

	public List<Passager> getAllPassagers();
	public Passager addPassager(Passager Passager);
}
