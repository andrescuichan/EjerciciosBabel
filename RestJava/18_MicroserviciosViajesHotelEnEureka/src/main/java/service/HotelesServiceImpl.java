package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelDao;
import modelo.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	
	HotelDao hotelesDao;
	
	
	public HotelesServiceImpl(@Autowired HotelDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}
	
	@Override
	public List<Hotel> allHotelesDisponibles() {
		return hotelesDao.findAll()
				.stream()
				.filter(h-> h.getDisponible()>0)
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> allHoteles() {
		return hotelesDao.findAll();
	}

	@Override
	public Hotel HotelNombre(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}
	
	
}
