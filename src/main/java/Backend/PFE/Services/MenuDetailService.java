package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.MenuDetail;

public interface MenuDetailService {
	public MenuDetail updateMenuDetail (MenuDetail MenuDetail );

	

	public List<MenuDetail > getAllMenuDetail ();

	public void deleletMenuDetail (Long id);

	List<MenuDetail> addMenuDetails(List<MenuDetail> MenuDetail);

	List<MenuDetail> findMenuDetailByMenuId(Long id);

}
