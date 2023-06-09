package Backend.PFE.Services;

import java.util.List;
import Backend.PFE.Entities.Role;


public interface RoleService {
	public List<Role> getAllRoles();
	public Role addRole(Role role);
	Role updateRole(Role role);
	void deleletRole(String role);
}
