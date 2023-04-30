package Backend.PFE.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Backend.PFE.Entities.MenuDetail;

@Repository
public interface MenuDetailRepository  extends JpaRepository<MenuDetail, Long>  {
public List<MenuDetail> findByMenuId(Long id);
}
