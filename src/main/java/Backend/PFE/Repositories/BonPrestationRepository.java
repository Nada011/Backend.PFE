package Backend.PFE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.BonPrestation;
@Repository
public interface BonPrestationRepository extends JpaRepository<BonPrestation, Long> {

}
