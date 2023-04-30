package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.Menu;
import Backend.PFE.Entities.MenuDetail;

public interface MenuService {
	public Menu updateMenu (Menu  Menu );


	public List<Menu > getAllMenu ();

	public void deleletMenu (Long id);


	public Menu addMenu(Menu Menu);


}
