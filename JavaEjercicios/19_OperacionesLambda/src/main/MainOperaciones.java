package main;

import entidades.Operaciones;

public class MainOperaciones {

	public static void main(String[] args) {
		double numero1 = 6.5;
		Integer numero2 = 4;
		
		Operaciones operacion = (a,b) ->  a + b;
		System.out.println(numero1 + " + " + numero2 + " : " + operacion.calcular(numero1, numero2));
		
		operacion = (a,b) ->  a - b;
		System.out.println(numero1 + " - " + numero2 + " : " + operacion.calcular(numero1, numero2));
		
		operacion = (a,b) ->  a * b;
		System.out.println(numero1 + " * " + numero2 + " : " + operacion.calcular(numero1, numero2));
		
		operacion = (a,b) ->  a / b;
		System.out.println(numero1 + " / " + numero2 + " : " + operacion.calcular(numero1, numero2));
		
		operacion = (a,b) -> {
			double potencia = 1;
			for (int i = 0; i < b; i++) {
				potencia = potencia * a;
			}
			return potencia;
		};
		System.out.println(numero1 + " ^ " + numero2 + " : " + operacion.calcular(numero1, numero2));
		
	}

}
