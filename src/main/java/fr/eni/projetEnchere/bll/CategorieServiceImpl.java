package fr.eni.projetEnchere.bll;

 
import java.util.List;
import java.util.Optional;
 
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
 
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieRepository;
import fr.eni.projetEnchere.exceptions.CategorieNotFoundRuntimeException;
 

@Service
@Primary
public class CategorieServiceImpl implements CategorieService {
	
	//Invocation du Repository de Categorie
	private CategorieRepository categorieRepository;

	//Constructeur
	public CategorieServiceImpl(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	@Override
	public List<Categorie> consulterCategorie() {
		return categorieRepository.findAllCategorie();
	}

 
	@Override
	public Categorie consulterCategorieParId(Integer noCategorie){
		Optional<Categorie> optCategorie = categorieRepository.findCategorieById(noCategorie);

		if(optCategorie.isPresent()) {
			return optCategorie.get();
		}
		throw new CategorieNotFoundRuntimeException();
	}

}
