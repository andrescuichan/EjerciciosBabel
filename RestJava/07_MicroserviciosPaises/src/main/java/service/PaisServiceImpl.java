package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import modelo.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	RestTemplate template;
	String urlBase = "https://restcountries.com/v2/all";
	
	
	public PaisServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	
	
	@Override
	public List<String> listaContinentes() {
		Pais[] paises = template.getForObject(urlBase, Pais[].class);
		return Arrays.stream(paises)
				.map(s-> s.getContinente()) //map/filter
				.distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<Pais> paisesPorContinentes(String continente) {
		Pais[] paises = template.getForObject(urlBase, Pais[].class);
		return Arrays.stream(paises)
				.filter(s-> s.getContinente().equals(continente))
				.collect(Collectors.toList());
	}

	@Override
	public long poblacionContinente(String continente) {
		Pais[] paises = template.getForObject(urlBase, Pais[].class);
		return Arrays.stream(paises)
				.filter(s-> s.getContinente().equals(continente))
				.collect(Collectors.summingLong(p -> p.getPoblacion()));
	}
		
}
