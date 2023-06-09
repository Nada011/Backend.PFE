package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Role;
import Backend.PFE.Entities.TypeRetard;
import Backend.PFE.Repositories.RoleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
	
	
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	@Override
	public Role updateRole(Role role) {
		Optional<Role> utOptional = roleRepository.findById(role.getRoleName());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return roleRepository.save(role);
		}
	}
	@Override
	public void deleletRole(String role) {
		roleRepository.deleteById(role);

	}

}
