package Backend.PFE.Services;

import java.util.List;

import Backend.PFE.Entities.TypeRetard;

public interface TypeRetardService {
	public TypeRetard updateTypeRetard(TypeRetard TypeRetard);

	public TypeRetard addTypeRetard(TypeRetard TypeRetard);

	public List<TypeRetard> getAllTypeRetard();

	public void deleletTypeRetard(Long id);
}
