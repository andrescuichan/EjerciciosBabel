package Java11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import entidades.Coche;
import entidades.ExportarPdf;
import entidades.UsuarioValidacion;
import modelo.negocio.GestorCoche;

public class HttpCliente {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean resultadoValidacion = false;
		boolean fin = false;
		GestorCoche gestorCoche = new GestorCoche();
		List<Coche> listaCoches = null;
		Coche c = null;
		System.out.println("Iniciar Sesion\n");
		
		for (int i = 2; i > -1 && !resultadoValidacion; i--) {
			System.out.println("Introduce tu nombre:");
			String nombre = sc.next();
			System.out.println("Introduce tu password:");
			String password = sc.next();
			resultadoValidacion = entrarAplicacion(nombre,password);
			if(resultadoValidacion) {
				System.out.println("Validacion Correcta\n");
				System.out.println("Bienvenido al menu de Coches");
			}else {
				System.out.println("\nPlease revise los datos introducidos");
				System.out.println("Numero de intentos disponibles: " + i);
			}
		}
		
		if(resultadoValidacion) {
			do {
				menu();
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Introduzca los datos del coche: \n" +
					"(Matricula/Marca/Modelo/Kilometros)");
					
					String matricula = sc.next();
					String marca = sc.next();
					String modelo = sc.next();
					int kilometros = sc.nextInt();
					
					c = new Coche();
					c.setMatricula(matricula);
					c.setMarca(marca);
					c.setModelo(modelo);
					c.setKilometros(kilometros);
					
					int alta = gestorCoche.alta(c);
					if(alta == 0) {
						System.out.println("Coche dado de alta");
					}else if(alta == 1) {
						System.out.println("Error de conexión con la BBDD");
					}else if(alta == 2){
						System.out.println("Solo se acepta matriculas de longitud 7 y no repetidas. Kilometros no negativos");
					}
					break;
				case 2:
					System.out.println("Introduzca el ID del coche: ");
					int id = sc.nextInt();
					boolean baja = gestorCoche.baja(id);
					if(baja) {
						System.out.println("Coche eliminado");
					}else {
						System.out.println("No se ha podido eliminar");
					}
					break;
				case 3:
					System.out.println("Introduzca el ID del coche a modificar: ");
					int idModificar = sc.nextInt();
					System.out.println("Introduzca los nuevos datos: \n" + 
					"(Matricula/Marca/Modelo/Kilometros)");
					
					String matriculaNew = sc.next();
					String marcaNew = sc.next();
					String modeloNew = sc.next();
					int kilometrosNew = sc.nextInt();
							
					c = new Coche();
					c.setId(idModificar);
					c.setMatricula(matriculaNew);
					c.setMarca(marcaNew);
					c.setModelo(modeloNew);
					c.setKilometros(kilometrosNew);
							
					int modificar = gestorCoche.modificar(c);
					if(modificar == 0) {
						System.out.println("Coche modificado");
					}else if(modificar == 1) {
						System.out.println("Error de conexión con la BBDD");
					}else if(modificar == 2){
						System.out.println("Solo se acepta matriculas de longitud 7 y no repetidas. Kilometros no negativos");
					}
					break;
				case 4:
					System.out.println("Introduzca el ID del coche a buscar: ");
					int idBuscar = sc.nextInt();
					c = gestorCoche.buscarId(idBuscar);
					System.out.println(c);
					break;
					
				case 5:
					System.out.println("Introduzca la Matricula del coche a buscar: ");
					String matriculaBuscar = sc.next();
					c = gestorCoche.buscarMatricula(matriculaBuscar);
					System.out.println(c);
					break;
					
				case 6:
					System.out.println("Introduzca la Marca del coche a buscar: ");
					String marcaBuscar = sc.next();
					c = gestorCoche.buscarMarca(marcaBuscar);
					System.out.println(c);
					break;
				
				case 7:
					System.out.println("Introduzca el Modelo del coche a buscar: ");
					String modeloBuscar = sc.next();
					c = gestorCoche.buscarModelo(modeloBuscar);
					System.out.println(c);
					break;
				
				case 8:
					listaCoches = gestorCoche.listar();
					System.out.println(listaCoches);
					break;
					
				case 9:
					Gson gson = new Gson();
					listaCoches = gestorCoche.listar();
					String json = gson.toJson(listaCoches);
					File file = new File("listaCoche.json");
					
					try(FileWriter fw = new FileWriter(file)){			
						fw.write(json);
						System.out.println("Fichero JSON creado");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 10:
					listaCoches = gestorCoche.listar();
					ExportarPdf ficheroPdf = new ExportarPdf(listaCoches);
					ficheroPdf.exportar();
					break;	
					
				case 11:
					fin = true;
					break;
					
				}
			}while(!fin);
		}
		System.out.println("Fin de programa");

	}
	
	
	private static void menu() {
		System.out.println("\n---------- Elija una opción: ----------");
		System.out.println("1- Alta de coche");
		System.out.println("2- Baja de coche");
		System.out.println("3- Modificar coche");
		System.out.println("4- Buscar coche por ID");
		System.out.println("5- Buscar coche por Matricula");
		System.out.println("6- Buscar coche por Marca");
		System.out.println("7- Buscar coche por Modelo");
		System.out.println("8- Lista de coches");
		System.out.println("9- Exportar a JSON");
		System.out.println("10- Exportar a PDF");
		System.out.println("11- Acabar Programa");
	}
	
	private static boolean entrarAplicacion(String nombre, String password) {
		
		UsuarioValidacion validacionResultado = null;
		
		try {
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/22_WebMenu/usuarios/login?nombre="+ nombre +"&password=" + password))
					  .GET()
					  .build();
			
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
			Gson gson = new Gson();
			String json = response.body();
			validacionResultado = gson.fromJson(json, UsuarioValidacion.class);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validacionResultado.isValidado();
	}
	
	
}
