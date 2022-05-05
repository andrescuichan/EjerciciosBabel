package converters;

import dtos.CuentaDto;
import dtos.MovimientoDto;
import modelo.Cuenta;
import modelo.Movimiento;

public interface ConversorEntityDto {
	public CuentaDto cuentaToDto(Cuenta cuenta);
	public Cuenta dtoToCuenta(CuentaDto dto);
	public MovimientoDto movimientoToDto(Movimiento movimiento);
	public Movimiento dtoToMovimiento(MovimientoDto dto);
}
