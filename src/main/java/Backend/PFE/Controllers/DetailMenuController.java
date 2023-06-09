package Backend.PFE.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import Backend.PFE.Entities.MenuDetail;
import Backend.PFE.Services.MenuDetailService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/Admin")
public class DetailMenuController {
	@Autowired
	private MenuDetailService DetailMenuService;

	@GetMapping("/DetailMenu/{id}")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<List<MenuDetail>> getDetailMenu(@PathVariable("id")Long id) {
		return ResponseEntity.ok().body(DetailMenuService.findMenuDetailByMenuId(id));
	}

	@PutMapping("DetailMenu/update")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<MenuDetail> updateDetailMenu(@RequestBody MenuDetail DetailMenu) {
		return ResponseEntity.ok().body(DetailMenuService.updateMenuDetail(DetailMenu));
	}

	@PostMapping("DetailMenu/add")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<List<MenuDetail>> createDetailMenu(@RequestBody List <MenuDetail> DetailMenu) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/DetailMenu/add").toUriString());

		return ResponseEntity.created(uri).body(DetailMenuService.addMenuDetails(DetailMenu));
	}
	

	@DeleteMapping("DetailMenu/delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public void deleletDetailMenu(@PathVariable("id") Long id) {

		DetailMenuService.deleletMenuDetail(id);
	}
}
