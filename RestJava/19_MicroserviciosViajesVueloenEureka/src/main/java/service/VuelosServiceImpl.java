package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VueloDao;
import modelo.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService{
	
	VueloDao vuelosDao;
	
	
	public VuelosServiceImpl(@Autowired VueloDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}


	@Override
	public List<Vuelo> allVuelos() {
		return vuelosDao.findAll();
	}


	@Override
	public List<Vuelo> allVuelosDisponibles(int plazasReservadas) {
		return vuelosDao.findAll()
				.stream()
				.filter(v-> (v.getPlazas()-plazasReservadas) >=0)
				.collect(Collectors.toList());
	}

	@Override
	public boolean actualizarPlazas(int idVuelo, int plazasReservadas) {
		Optional<Vuelo> v = vuelosDao.findById(idVuelo);
		if(v.isPresent()) {
			Vuelo vuelo = v.get();
			int plazasDisponibles = vuelo.getPlazas() - plazasReservadas;
			if (plazasDisponibles >= 0) {
				vuelo.setPlazas(plazasDisponibles);
				vuelosDao.save(vuelo);
				return true;
			}
		}
		return false;	
	}
	
	
}
