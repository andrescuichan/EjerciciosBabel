package converters;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import modelo.Cuenta;
import modelo.Movimiento;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto{

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		if(cuenta != null) {
			return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipocuenta(),
					cuenta.getMovimientos()
					.stream()
					.map(a->a.getIdMovimiento())
					.collect(Collectors.toList()));
		}else {
			return null;
		}
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(), dto.getSaldo(), dto.getTipocuenta());
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(), movimiento.getIdCuenta(), movimiento.getFecha(), 
				movimiento.getCantidad(), movimiento.getOperacion());
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdMovimiento(), dto.getIdCuenta(), dto.getFecha(), 
				dto.getCantidad(), dto.getOperacion());
	}
}
