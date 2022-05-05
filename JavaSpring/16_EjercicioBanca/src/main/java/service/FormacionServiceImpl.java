package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import converters.ConversorEntityDto;
import dao.CuentaDao;
import dao.MovimientoDao;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import modelo.Cuenta;
import modelo.Movimiento;

@Service
public class FormacionServiceImpl implements FormacionService{
	
	@Autowired
	ConversorEntityDto conversor;
	
	CuentaDao cuentasDao;
	MovimientoDao movimientosDao;
	
	public FormacionServiceImpl(@Autowired CuentaDao cuentasDao, @Autowired MovimientoDao movimientosDao) {
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
	}


	@Override
	public CuentaDto encontrarByNumeroCuenta(int numeroCuenta) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		return cuenta.isPresent()?conversor.cuentaToDto(cuenta.get()):null;
	}

	@Override
	public void ingresarDinero(int numeroCuenta, double dineroIngresado) {
		Optional<Cuenta> c = cuentasDao.findById(numeroCuenta);
		Cuenta cuenta = c.get();
		cuenta.setSaldo(cuenta.getSaldo() + dineroIngresado);
		cuentasDao.save(cuenta);
		this.actualizarMovimientos(numeroCuenta,dineroIngresado, "ingreso");
	}
	
	@Override
	public void extraerDinero(int numeroCuenta, double dineroExtraido) {
		Optional<Cuenta> c = cuentasDao.findById(numeroCuenta);
		Cuenta cuenta = c.get();
		cuenta.setSaldo(cuenta.getSaldo() - dineroExtraido);
		cuentasDao.save(cuenta);
		this.actualizarMovimientos(numeroCuenta,dineroExtraido, "extraccion");
	}
	
	@Override
	public void transferenciaDinero(int numeroCuentaOrigen, double dineroTransferido, int numeroCuentaDestino) {
		this.extraerDinero(numeroCuentaOrigen,dineroTransferido);
		this.ingresarDinero(numeroCuentaDestino,dineroTransferido);
	}

	@Override
	public void actualizarMovimientos(int numeroCuenta, double dineroIngresado, String operacion) {
		Movimiento movimiento = new Movimiento(numeroCuenta, new Date(System.currentTimeMillis()) , dineroIngresado , operacion);
		movimientosDao.save(movimiento);
	}

	@Override
	public List<MovimientoDto> consultarMovimientos(int numeroCuenta, Date f1, Date f2) {
		return movimientosDao.findByFechaBetween(numeroCuenta, f1,f2)
				.stream()
				.map(c->conversor.movimientoToDto(c))
				.collect(Collectors.toList());
	}
}
