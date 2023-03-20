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

import Backend.PFE.Entities.TypeRetard;
import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Services.TypeRetardService;
import Backend.PFE.Services.UtilisateurService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class TypeRetardController {
	@Autowired
	private TypeRetardService TypeRetardService;

	@GetMapping("/typeRetards")
	public ResponseEntity<List<TypeRetard>> getAllTypeRetards() {
		return ResponseEntity.ok().body(TypeRetardService.getAllTypeRetard());
	}

	@PutMapping("typeRetard/update")
	public ResponseEntity<TypeRetard> updateTypeRetard(@RequestBody TypeRetard TypeRetard) {
		return ResponseEntity.ok().body(TypeRetardService.updateTypeRetard(TypeRetard));
	}

	@PostMapping("typeRetard/add")
	public ResponseEntity<TypeRetard> createTypeRetard(@RequestBody TypeRetard TypeRetard) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/typeRetard/add").toUriString());

		return ResponseEntity.created(uri).body(TypeRetardService.addTypeRetard(TypeRetard));
	}

	@DeleteMapping("typeRetard/delete/{id}")
	public void deleletTypeRetard(@PathVariable("id") Long id) {

		TypeRetardService.deleletTypeRetard(id);
	}

}
