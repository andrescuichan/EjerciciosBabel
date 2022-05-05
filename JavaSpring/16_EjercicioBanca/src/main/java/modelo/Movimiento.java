package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="movimientos")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	private int idCuenta;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date fecha;
	private double cantidad;
	private String operacion;
	@ManyToOne()
    @JoinColumn(name="idCuenta",
    referencedColumnName = "numeroCuenta", insertable = false,updatable = false)
    private Cuenta cuenta;
	
	
	public Movimiento(int idCuenta, Date fecha, double cantidad, String operacion) {
		super();
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	
	public Movimiento(int idMovimiento, int idCuenta, Date fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	
	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", idCuenta=" + idCuenta + ", fecha=" + fecha
				+ ", cantidad=" + cantidad + ", operacion=" + operacion + "]";
	}
	
}
