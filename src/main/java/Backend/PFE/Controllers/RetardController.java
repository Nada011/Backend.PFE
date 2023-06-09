package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.BonPrestation;
import Backend.PFE.Entities.Contrat;
import Backend.PFE.Entities.Retard;
import Backend.PFE.Entities.addRetardRequest;
import Backend.PFE.Services.BonPrestationService;
import Backend.PFE.Services.RetardService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping
public class RetardController {
	@Autowired
	private RetardService RetardService;
	@Autowired
	private BonPrestationService bonPrestationService;

	@GetMapping("/Retard")
	@PreAuthorize("hasRole('Agent de comptoir')")
	public ResponseEntity<List<Retard>> getAllRetards() {
		return ResponseEntity.ok().body(RetardService.getAllRetards());
	}
	@PostMapping("Retard/add")
	@PreAuthorize("hasRole('Chef d’escale')")
	public ResponseEntity<Retard> addRetard(@RequestBody addRetardRequest Retard) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Retard/add").toUriString());

		return ResponseEntity.created(uri).body(RetardService.addRetard(Retard));
		
	}
	@PutMapping("Retard/bon/update")
	@PreAuthorize("hasRole('Agent de comptoir')")
	BonPrestation updateValidite(@RequestBody BonPrestation bonPrestation) {
		return bonPrestationService.updateValidite(bonPrestation);
	}
}
