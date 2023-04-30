package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Fournisseur;
import Backend.PFE.Services.ContratService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class ContratController {
	@Autowired
	private ContratService ContratService;

	
	@GetMapping("/Contrats")
	public List<Contrat> getAllContrats() {
		return ContratService.getAllContrats();
	}
	@PutMapping("Contrat/update")
	public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat Contrat) {
		return ResponseEntity.ok().body(ContratService.updateContrat(Contrat));
	}

	@PostMapping("Contrat/add")
	public ResponseEntity<Contrat> createContrat(@RequestBody Contrat Contrat) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/Contrat/add").toUriString());
		return ResponseEntity.created(uri).body(ContratService.addContrat(Contrat));
	}

	@DeleteMapping("Contrat/delete/{id}")
	public void deleteContrat(@PathVariable("id") Long id) {

		ContratService.deleletContrat(id);

	}
}
