package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Menu;
import Backend.PFE.Entities.MenuDetail;
import lombok.AllArgsConstructor;
import Backend.PFE.Repositories.MenuRepository;


@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {
	
	
	@Autowired
	private MenuRepository MenuRepository;
	@Override
	public Menu updateMenu(Menu Menu) {
		
	Optional<Menu> utOptional = MenuRepository.findById(Menu.getId());
	  
	if (utOptional.isEmpty()) {
		return null;
	} else {
		
		return MenuRepository.save(Menu);
	}
	}

	@Override
	public Menu addMenu(Menu Menu) {
	
		return MenuRepository.save(Menu);
	}

	@Override
	public List<Menu> getAllMenu() {
		return MenuRepository.findAll();
	}

	@Override
	public void deleletMenu(Long id) {
		MenuRepository.deleteById(id);
	}

}
