package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Entities.Vol;
import Backend.PFE.Services.VolService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping
public class VolController {
	@Autowired
	private VolService VolService;

	@GetMapping("/Vols")
	@PreAuthorize("hasRole('Chef d’escale')")
	public ResponseEntity<List<Vol>> getAllVols() {
		return ResponseEntity.ok().body(VolService.getAllVols());
	}
	@PostMapping("vol/add")
	@PreAuthorize("hasRole('Chef d’escale')")
	public ResponseEntity<Vol> addVol(@RequestBody Vol vol) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("vol/add").toUriString());

		return ResponseEntity.created(uri).body(VolService.addVol(vol));
		
	}
}
