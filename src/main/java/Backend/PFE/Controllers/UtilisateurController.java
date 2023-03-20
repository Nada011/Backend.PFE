package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Services.UtilisateurService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class UtilisateurController {
	@Autowired
	private UtilisateurService UtilisateurService;

	@GetMapping("/users")
	public ResponseEntity<List<Utilisateur>> getAllUsers() {
		return ResponseEntity.ok().body(UtilisateurService.getAllUsers());
	}

	@PutMapping("user/update")
	public ResponseEntity<Utilisateur> updateUsers(@RequestBody Utilisateur user) {
		return ResponseEntity.ok().body(UtilisateurService.updateUser(user));
	}

	@PostMapping("user/add")
	public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/user/add").toUriString());

		return ResponseEntity.created(uri).body(UtilisateurService.addUser(user));
	}

	@DeleteMapping("user/delete/{id}")
	public void deleteUser(@PathVariable("id") Long id) {

		UtilisateurService.deleletUser(id);
	}
}
