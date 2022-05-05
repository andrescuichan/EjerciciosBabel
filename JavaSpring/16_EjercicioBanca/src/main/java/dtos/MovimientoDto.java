package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {
	
	private int idMovimiento;
	private int idCuenta;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Europe/Madrid")
	private Date fecha;
	private double cantidad;
	private String operacion;
}
