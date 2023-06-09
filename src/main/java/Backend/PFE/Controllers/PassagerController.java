package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Backend.PFE.Entities.Passager;
import Backend.PFE.Services.PassagerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping
public class PassagerController {
	@Autowired
	private PassagerService PassagerService;

	@GetMapping("/Passagers")
	public ResponseEntity<List<Passager>> getAllPassagers() {
		return ResponseEntity.ok().body(PassagerService.getAllPassagers());
	}
	@PostMapping("Passager/add")
	public ResponseEntity<Passager> addPassager(@RequestBody Passager Passager) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Passager/add").toUriString());

		return ResponseEntity.created(uri).body(PassagerService.addPassager(Passager));
		
	}
}
