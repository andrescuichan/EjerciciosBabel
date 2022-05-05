package service;

import java.util.Date;
import java.util.List;
import dtos.CuentaDto;
import dtos.MovimientoDto;

public interface FormacionService {
	CuentaDto encontrarByNumeroCuenta(int numeroCuenta);
	void ingresarDinero(int numeroCuenta, double dineroIngresado);
	void extraerDinero(int numeroCuenta, double dineroExtraido);
	void transferenciaDinero(int numeroCuentaOrigen, double dineroTransferido, int numeroCuentaDestino);
	void actualizarMovimientos(int numeroCuenta, double dineroIngresado, String operacion);
	List<MovimientoDto> consultarMovimientos(int numeroCuenta, Date f1, Date f2);
}
