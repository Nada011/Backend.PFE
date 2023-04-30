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
import Backend.PFE.Entities.Menu;
import Backend.PFE.Entities.MenuDetail;
import Backend.PFE.Entities.TypeRetard;
import Backend.PFE.Services.MenuService;
import Backend.PFE.Services.TypeRetardService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class MenuController {
	@Autowired
	private MenuService MenuService;

	@GetMapping("/Menu")
	public ResponseEntity<List<Menu>> getAllMenu() {
		return ResponseEntity.ok().body(MenuService.getAllMenu());
	}
	@PostMapping("Menu/add")
	public ResponseEntity<Menu> createContrat(@RequestBody Menu Menu) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/Menu/add").toUriString());
		return ResponseEntity.created(uri).body(MenuService.addMenu(Menu));
	}

	@PutMapping("Menu/update")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu Menu) {
		return ResponseEntity.ok().body(MenuService.updateMenu(Menu));
	}



	@DeleteMapping("Menu/delete/{id}")
	public void deleletMenu(@PathVariable("id") Long id) {

		MenuService.deleletMenu(id);
	}

}
