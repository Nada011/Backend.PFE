package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.Menu;
import Backend.PFE.Entities.MenuDetail;
import Backend.PFE.Repositories.MenuDetailRepository;
import Backend.PFE.Repositories.ContratRepository;
import Backend.PFE.Repositories.MenuRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MenuDetailServiceImpl implements MenuDetailService {
	@Autowired
	private MenuDetailRepository MenuDetailRepository;
	@Autowired
	private ContratRepository ContratRepository;
	@Autowired
	private MenuRepository MenuRepository;
	@Autowired
	private MenuService MenuService;
	@Override
	public MenuDetail updateMenuDetail(MenuDetail MenuDetail) {
	Optional<MenuDetail> utOptional = MenuDetailRepository.findById(MenuDetail.getId());

	if (utOptional.isEmpty()) {
		return null;
	} else {
		Menu menu=MenuDetail.getMenu();
		double total =0;
		MenuDetailRepository.save(MenuDetail);
		List<MenuDetail>details=MenuDetailRepository.findByMenuId(MenuDetail.getIdMenu());
		if(details!=null) {
		for(MenuDetail detail:details) {
			total=total+detail.getPrix();
		}
		menu.setTotal(total);
		MenuRepository.save(menu);}
		MenuService.updateMenu(MenuDetail.getMenu());
		return MenuDetail;
	}
	}


	@Override
	public List <MenuDetail> addMenuDetails(List<MenuDetail> MenuDetail) {
		MenuDetailRepository.saveAll(MenuDetail);
		double total =0;
		Menu menu=MenuDetail.get(0).getMenu();;
	Long id =	MenuDetail.get(0).getIdMenu();
	List<MenuDetail>details=MenuDetailRepository.findByMenuId(id);
	if(details!=null) {
	for(MenuDetail detail:details) {
		total=total+detail.getPrix();
	
	}
	menu.setTotal(total);
	MenuRepository.save(menu);
		}
		return MenuDetail;
	}
	@Override
	public List<MenuDetail> getAllMenuDetail() {
		return MenuDetailRepository.findAll();
	}

	@Override
	public void deleletMenuDetail(Long id) {
	Optional<MenuDetail> detail=	MenuDetailRepository.findById(id);
	double prix =detail.get().getPrix();
	double total = detail.get().getMenu().getTotal();
detail.get().getMenu().setTotal(total-prix);
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
