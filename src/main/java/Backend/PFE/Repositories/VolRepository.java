package Backend.PFE.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.Passager;
import Backend.PFE.Entities.Vol;

@Repository
public interface VolRepository extends JpaRepository<Vol, Long>{
	
}
