package Backend.PFE.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Role;
import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import Backend.PFE.Repositories.RoleRepository;


@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private UtilisateurRepository UserRepository;
	@Autowired
	private RoleRepository RoleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public List<Utilisateur> getAllUsers() {

		return UserRepository.findAll();
	}

	@Override
	public Utilisateur addUser(Utilisateur user) {
		user.setStatutCompte(true);
		user.setMotPasse(getEncodedPassword(user.getMotPasse()));
		return UserRepository.save(user);
	}

	@Override
	public Utilisateur updateUser(Utilisateur user) {
		Optional<Utilisateur> utOptional = UserRepository.findById(user.getEmail());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			user.setMotPasse(getEncodedPassword(user.getMotPasse()));
			return UserRepository.save(user);
		}
	}
	public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        RoleRepository.save(adminRole);

      

        Utilisateur adminUser = new Utilisateur();
        adminUser.setNom("admin123");
        adminUser.setEmail("admin123");
        adminUser.setMotPasse(getEncodedPassword("admin@pass"));
        adminUser.setPrenom("admin");
        adminUser.setStatutCompte(true);
        adminUser.setRole(adminRole);
        UserRepository.save(adminUser);


    }

	@Override
	public void deleletUser(String email) {
		UserRepository.deleteById(email);;

	}
public String getEncodedPassword(String password) {
	return passwordEncoder.encode(password);
}
}
