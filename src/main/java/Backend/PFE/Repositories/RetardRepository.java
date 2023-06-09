package Backend.PFE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.Retard;
@Repository
public interface RetardRepository extends JpaRepository<Retard, Long>{

}
