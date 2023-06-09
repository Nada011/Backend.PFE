package Backend.PFE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.PFE.Entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

}
