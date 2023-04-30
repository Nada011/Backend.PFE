package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.MenuDetail;
import Backend.PFE.Repositories.MenuDetailRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MenuDetailServiceImpl implements MenuDetailService {
	@Autowired
	private MenuDetailRepository MenuDetailRepository;

	@Override
	public MenuDetail updateMenuDetail(MenuDetail MenuDetail) {
	Optional<MenuDetail> utOptional = MenuDetailRepository.findById(MenuDetail.getId());

	if (utOptional.isEmpty()) {
		return null;
	} else {
		return MenuDetailRepository.save(MenuDetail);
	}
	}

	@Override
	public MenuDetail addMenuDetail(MenuDetail MenuDetail) {
	
		return MenuDetailRepository.save(MenuDetail);
	}
	@Override
	public List <MenuDetail> addMenuDetails(List<MenuDetail> MenuDetail) {
		
		return MenuDetailRepository.saveAll(MenuDetail);
	}
	@Override
	public List<MenuDetail> getAllMenuDetail() {
		return MenuDetailRepository.findAll();
	}

	@Override
	public void deleletMenuDetail(Long id) {
		MenuDetailRepository.deleteById(id);
	}
	@Override
	public List<MenuDetail> findMenuDetailByMenuId(Long id) {
		List <MenuDetail> details = MenuDetailRepository.findByMenuId(id);

		if (details.isEmpty()) {
			return null;
		} else {
			return details;
		}
	
	}
}
