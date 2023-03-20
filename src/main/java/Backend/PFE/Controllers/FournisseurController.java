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

import Backend.PFE.Entities.Fournisseur;
import Backend.PFE.Services.FournisseurService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class FournisseurController {
	@Autowired
	private FournisseurService FournisseurService;

	@GetMapping("/fournisseurs")
	public ResponseEntity<List<Fournisseur>> getAllUsers() {
		return ResponseEntity.ok().body(FournisseurService.getAllFournisseurs());
	}

	@PutMapping("fournisseur/update")
	public ResponseEntity<Fournisseur> updateUsers(@RequestBody Fournisseur fournisseur) {
		return ResponseEntity.ok().body(FournisseurService.updateFournisseur(fournisseur));
	}

	@PostMapping("fournisseur/add")
	public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/fournisseur/add").toUriString());
		return ResponseEntity.created(uri).body(FournisseurService.addFournisseur(fournisseur));
	}

	@DeleteMapping("fournisseur/delete/{id}")
	public void deleteFournisseur(@PathVariable("id") Long id) {

		FournisseurService.deleletFournisseur(id);

	}
}
