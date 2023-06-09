package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Utilisateur;

public interface UtilisateurService {
	public Utilisateur updateUser(Utilisateur user);

	public Utilisateur addUser(Utilisateur user);

	public List<Utilisateur> getAllUsers();

	public void deleletUser(String email);

}