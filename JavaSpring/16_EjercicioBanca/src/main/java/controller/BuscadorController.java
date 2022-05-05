package controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class BuscadorController {
	
	private int numeroCuentaValidada = 0;
	
	@Autowired
	FormacionService buscadorService;
	
	
	@PostMapping(value="Validar")
	public String validarCuenta(@RequestParam("numeroCuenta") int numeroCuenta) {
		CuentaDto cuenta = buscadorService.encontrarByNumeroCuenta(numeroCuenta);
		if(cuenta != null) {
			this.numeroCuentaValidada = numeroCuenta;
			return "menu";
		}else {
			return "validarCuenta";
		}
	}
	
	@PostMapping(value="Ingresar")
	public String ingresarDinero(@RequestParam("cantidad") double dinero) {
		buscadorService.ingresarDinero(this.numeroCuentaValidada, dinero);
		return "menu";
	}
	
	@PostMapping(value="Extraer")
	public String extraerDinero(@RequestParam("cantidad") double dinero) {
		buscadorService.extraerDinero(this.numeroCuentaValidada, dinero);
		return "menu";
	}
	
	@PostMapping(value="Transferir")
	public String transferirDinero(@RequestParam("cantidad") double dinero, @RequestParam("numeroCuentaDestino") int numeroCuentaDestino) {
		buscadorService.transferenciaDinero(this.numeroCuentaValidada, dinero, numeroCuentaDestino);
		return "menu";
	}
	
	@GetMapping(value="MovimientosBetweenFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> cursoEntreFechas(@RequestParam("f1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date f1, 
													  @RequestParam("f2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date f2) {
		return buscadorService.consultarMovimientos(numeroCuentaValidada,f1,f2);
	}
	
	@GetMapping(value="ConsultarSaldo")
	public @ResponseBody double consultarSaldoCuenta() {
		CuentaDto cuenta = buscadorService.encontrarByNumeroCuenta(this.numeroCuentaValidada);
		return cuenta.getSaldo();
	}
}
