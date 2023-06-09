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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.BonPrestation;
import Backend.PFE.Services.BonPrestationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BonPrestationController {
	@Autowired
	private  BonPrestationService  BonPrestationService;

	
	@GetMapping("/BonPrestation")
	public List<BonPrestation> getAllBonPrestation() {
		return BonPrestationService.getAllBonPrestation();
	}
	
	
	@PutMapping("BonPrestation/update")
	public ResponseEntity<BonPrestation> updateBonPrestation(@RequestBody BonPrestation BonPrestation) {
		return ResponseEntity.ok().body(BonPrestationService.updateBonPrestation(BonPrestation));
	}

	@PostMapping("BonPrestation/add")
	public ResponseEntity<BonPrestation> createBonPrestation(@RequestBody BonPrestation BonPrestation) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("BonPrestation/add").toUriString());
		return ResponseEntity.created(uri).body(BonPrestationService.addBonPrestation(BonPrestation));
	}

	@DeleteMapping("BonPrestation/delete/{id}")
	public void deleteBonPrestation(@PathVariable("id") Long id) {

		BonPrestationService.deleletBonPrestation(id);

	}
}
