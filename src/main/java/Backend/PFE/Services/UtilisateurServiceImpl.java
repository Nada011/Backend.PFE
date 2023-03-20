package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private UtilisateurRepository UserRepository;

	@Override
	public List<Utilisateur> getAllUsers() {

		return UserRepository.findAll();
	}

	@Override
	public Utilisateur addUser(Utilisateur user) {
		user.setStatutCompte(true);
		return UserRepository.save(user);
	}

	@Override
	public Utilisateur updateUser(Utilisateur user) {
		Optional<Utilisateur> utOptional = UserRepository.findById(user.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return UserRepository.save(user);
		}
	}

	@Override
	public void deleletUser(Long id) {
		UserRepository.deleteById(id);

	}

}
