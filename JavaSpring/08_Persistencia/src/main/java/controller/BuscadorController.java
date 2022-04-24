package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import modelo.Producto;
import service.BuscadorServiceInterface;

@CrossOrigin("*")
@Controller
public class BuscadorController {
	
	@Autowired
	BuscadorServiceInterface buscadorService;
		
	
	@PostMapping(value="Alta")
	public String add(@ModelAttribute Producto producto, HttpServletRequest request) {
		
		buscadorService.altaProducto(producto);
		return "inicio";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminado(@RequestParam("nombre") String nombre, HttpServletRequest request) {
		
		buscadorService.eliminarProducto(nombre);
		return "inicio";
	}
	
	@GetMapping(value="Modificar")
	public String cambiar(@RequestParam("nombre") String nombre, @RequestParam("precio") Double precio ,HttpServletRequest request) {
		
		buscadorService.modificarPrecioProducto(nombre,precio);
		return "inicio";
	}
	
	@GetMapping(value="Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion, HttpServletResponse response) {
		
		return buscadorService.productosSeccion(seccion);
	}
	
	
}
