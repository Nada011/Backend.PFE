package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.BonPrestation;

public interface BonPrestationService {
	public BonPrestation updateBonPrestation(BonPrestation BonPrestation);

	public BonPrestation addBonPrestation(BonPrestation BonPrestation);

	public List<BonPrestation> getAllBonPrestation();

	public void deleletBonPrestation(Long id);

	BonPrestation updateValidite(BonPrestation bonPrestation);
}
