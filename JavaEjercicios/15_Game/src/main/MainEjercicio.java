package main;

import java.util.Scanner;

import entidad.Arco;
import entidad.Arma;
import entidad.Curanderos;
import entidad.Espada;
import entidad.Guerrero;
import entidad.Hechizos;
import entidad.Mago;
import entidad.Personaje;
import entidad.Rezos;

public class MainEjercicio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("----- Bienvenidos a Metin2 -----");
		System.out.println("Escribe el nick de tu personaje: ");
		String nickPersonaje = sc.next();
		System.out.println("Elije el tipo de personaje con el que quieres jugar:\n");
		dibujarGuerrero();
		dibujarMago();
		dibujarCurandero();
		String opcionPersonaje = sc.next();
		System.out.println("Elije el tipo de arma con el que vas a jugar:\n");
		dibujarEspada();
		dibujarArco();
		dibujarHechizos();
		dibujarRezos();
		String opcionArma = sc.next();
		
		Personaje personaje1 = crearPersonaje(opcionPersonaje,opcionArma,nickPersonaje);
		Personaje personaje2 = crearEnemigoAleatorio();
		System.out.println("\r---- LA BATALLA EN EL ABISMO DE HELM COMENZARA ----");
		System.out.println(personaje1.getNombre() + " VS " + personaje2.getNombre() + "\n");
		
		boolean muerto = false;
	
		do {
			pressAnyKeyToContinue();
			muerto = personaje1.atacar(personaje2);
			if (!muerto) {
				muerto = personaje2.atacar(personaje1);
			}
		}while(!muerto);
		
		System.out.println("FIN DEL JUEGO");
	}
	
	static public void pressAnyKeyToContinue()
    { 
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Press Enter key to continue...");
        seguir = teclado.nextLine();

   }
	
	public static Personaje crearEnemigoAleatorio() {
		
		String tipoPersonaje = "";
		String tipoArma= "";
		int getRandomValue = (int) (Math.random()*(4-1)) + 1;
		System.out.println("TU ENEMIGO VA A SER: \r 'LORD VOLDEMORT'");
		System.out.println("Es de tipo:");
		
		if(getRandomValue == 1) {
			tipoPersonaje = "Guerrero";
			dibujarGuerrero();
		}else if(getRandomValue == 2) {
			tipoPersonaje = "Mago";
			dibujarMago();
		}else if(getRandomValue == 3) {
			tipoPersonaje = "Curandero";
			dibujarCurandero();
		}
		
		getRandomValue = (int) (Math.random()*(5-1)) + 1;
		System.out.println("Con el arma:");
		if(getRandomValue == 1) {
			tipoArma = "Espada";
			dibujarEspada();
		}else if(getRandomValue == 2) {
			tipoArma = "Arco";
			dibujarArco();
		}else if(getRandomValue == 3) {
			tipoArma = "Hechizos";
			dibujarHechizos();
		}else if(getRandomValue == 4) {
			tipoArma = "Rezos";
			dibujarRezos();
		}

		return crearPersonaje(tipoPersonaje, tipoArma ,"Lord Voldemort");

	}
	
	public static Personaje crearPersonaje(String tipoPersonaje, String tipoArma, String nick) {
		
		Arma arma;
		Personaje personaje;
		
		if(tipoArma.equals("Espada")) {
			arma = new Espada(); 
		}else if(tipoArma.equals("Arco")) {
			arma = new Arco(); 
		}else if(tipoArma.equals("Hechizos")) {
			arma = new Hechizos();
		}else {
			arma = new Rezos();
		}
		
		if(tipoPersonaje.equals("Guerrero")) {
			personaje = new Guerrero(nick, arma);
		}else if(tipoPersonaje.equals("Mago")) {
			personaje = new Mago(nick, arma);
		}else{
			personaje = new Curanderos(nick, arma);
		}
		return personaje;
	}
	
	public static void dibujarGuerrero() {
		System.out.println(" Guerrero\r"
				+ "             .--.\r\n"
				+ "            /.--.\\\r\n"
				+ "            |====|\r\n"
				+ "            |`::`|\r\n"
				+ "        .-;`\\..../`;-.\r\n"
				+ "       /  |...::...|  \\\r\n");
	}
	
	public static void dibujarMago() {
		System.out.println(" Mago\r"
				+ "               .               . (*.) .    \r\n"
				+ "              /:\\         .  ( .(.. ) )\r\n"
				+ "             /:.:\\       . ( (..*  ).*) .\r\n"
				+ "            /:.:.:\\         ( *  . ). .)  .\r\n"
				+ "           |wwWWWww|      .  ( (. *.) .   \r\n"
				+ "           (((\"\"\")))           /\r\n"
				+ "           (. @ @ .)          /\r\n"
				+ "           (( (_) ))      __ /\r\n"
				+ "          .-)))o(((-.    |:.\\\r\n");
	}
	
	public static void dibujarCurandero() {
		System.out.println(" Curandero\r"
				+ "                     \\'/\r\n"
				+ "                    -= * =-\r\n"
				+ "                .-\"-. / #,_\r\n"
				+ "               / /\\_ \\  `#|\\\r\n"
				+ "              / /')'\\ \\  /#/\r\n"
				+ "             (  \\ = /  )/\\/#\r\n"
				+ "              )  ) (  (/  \\\r\n"
				+ "             (_.;`\"`;._)  |\r\n");
	}
	
	public static void dibujarEspada() {
		System.out.println(" Espada\r\n"
				+ "              (@|\r\n"
				+ " ,,           ,)|_________________________________\r\n"
				+ "//\\\\8@8@8@8@8@8 / _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \\\r\n"
				+ "\\\\//8@8@8@8@8@8 \\_________________________________/\r\n"
				+ " ``           `)|\r\n"
				+ "              (@| \r\n");
	}
	
	public static void dibujarArco() {
		System.out.println(" Arco\r\n"
				+ "          (\r\n"
				+ "           \\\r\n"
				+ "            \\\r\n"
				+ "             )\r\n"
				+ "    ###------------>\r\n"
				+ "             )\r\n"
				+ "            /\r\n"
				+ "           /\r\n"
				+ "          (\r\n");	
	}
	
	public static void dibujarHechizos() {
		System.out.println(" Hechizos\r\n"
				+ "      .\r\n"
				+ "       O  o\r\n"
				+ "         .\r\n"
				+ "      .    O\r\n"
				+ "          .\r\n"
				+ "       o   .\r\n"
				+ "    _________\r\n"
				+ "  c(`       ')o\r\n"
				+ "    \\.     ,/\r\n"
				+ "    _//^---^\\\\_  \r\n");
	}
	
public static void dibujarRezos() {
	System.out.println(" Rezos\r\n"
			+ "         __...--~~~~~-._   _.-~~~~~--...__\r\n"
			+ "       //               `V'               \\\\ \r\n"
			+ "      //                 |                 \\\\ \r\n"
			+ "     //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \r\n"
			+ "    //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\r\n"
			+ "   ====================\\\\|//====================\r\n"
			+ "                       `---`");
	}
	
}
