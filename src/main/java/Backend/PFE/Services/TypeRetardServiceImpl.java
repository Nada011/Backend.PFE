package Backend.PFE.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PFE.Entities.TypeRetard;
import Backend.PFE.Repositories.TypeRetardRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TypeRetardServiceImpl implements TypeRetardService {
	@Autowired
	private TypeRetardRepository TypeRetardRepository;

	@Override
	public TypeRetard updateTypeRetard(TypeRetard TypeRetard) {
		Optional<TypeRetard> utOptional = TypeRetardRepository.findById(TypeRetard.getId());

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return TypeRetardRepository.save(TypeRetard);
		}
	}

	@Override
	public TypeRetard addTypeRetard(TypeRetard TypeRetard) {
		return TypeRetardRepository.save(TypeRetard);
	}

	@Override
	public List<TypeRetard> getAllTypeRetard() {
		// TODO Auto-generated method stub
		return TypeRetardRepository.findAll();
	}

	@Override
	public void deleletTypeRetard(Long id) {
		TypeRetardRepository.deleteById(id);

	}

}
