package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@Autowired
	private Backend.PFE.Services.UtilisateurServiceImpl UtilisateurServiceImpl;
	@GetMapping("/users")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<List<Utilisateur>> getAllUsers() {
		return ResponseEntity.ok().body(UtilisateurService.getAllUsers());
	}

	@PutMapping("user/update")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Utilisateur> updateUsers(@RequestBody Utilisateur user) {
		return ResponseEntity.ok().body(UtilisateurService.updateUser(user));
	}

	@PostMapping("user/add")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/user/add").toUriString());

		return ResponseEntity.created(uri).body(UtilisateurService.addUser(user));
	}
	   @PostConstruct
	    public void initRoleAndUser() {
	        UtilisateurServiceImpl.initRoleAndUser();
	    }
	@DeleteMapping("user/delete/{email}")
	@PreAuthorize("hasRole('Admin')")
	public void deleteUser(@PathVariable("id") String email) {

		UtilisateurService.deleletUser(email);
	}
}
