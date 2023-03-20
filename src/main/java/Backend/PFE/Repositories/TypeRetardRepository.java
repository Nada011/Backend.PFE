package Backend.PFE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.TypeRetard;

@Repository

public interface TypeRetardRepository extends JpaRepository<TypeRetard, Long> {

}
