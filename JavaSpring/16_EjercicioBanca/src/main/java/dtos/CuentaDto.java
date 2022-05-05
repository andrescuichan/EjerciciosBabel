package dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CuentaDto {
	
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;
	List<Integer> Movimientos;
}
