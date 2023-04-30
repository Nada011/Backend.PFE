package Backend.PFE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.Menu;

@Repository

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
