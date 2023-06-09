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

import Backend.PFE.Entities.Role;
import Backend.PFE.Entities.TypeRetard;
import Backend.PFE.Services.RoleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping
public class RoleController {
	@Autowired
	private RoleService RoleService;

	@GetMapping("/Role")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<List<Role>> getAllRetards() {
		return ResponseEntity.ok().body(RoleService.getAllRoles());
	}
	@PostMapping("Role/add")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Role> addRetard(@RequestBody Role Role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Retard/add").toUriString());

		return ResponseEntity.created(uri).body(RoleService.addRole(Role));
		
	}
	@PutMapping("Role/update")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		return ResponseEntity.ok().body(RoleService.updateRole(role));
	}
	@DeleteMapping("Role/delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public void deleletRole(@PathVariable("id") String role) {

		RoleService.deleletRole(role);
	}
}
