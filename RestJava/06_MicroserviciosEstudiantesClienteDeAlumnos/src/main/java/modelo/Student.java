package modelo;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
	
	private String nombre;
	private String curso;
	@JsonProperty(value="nota")
	private double puntuacion;

}
