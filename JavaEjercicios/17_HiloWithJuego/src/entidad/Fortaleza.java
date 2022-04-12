package entidad;

import java.util.Scanner;

public class Fortaleza {
	
	private Personaje boss;
	private boolean muertoBoss = false;

	
	public Fortaleza(Personaje boss) {
		this.boss = boss;
	}
	
	public synchronized void batalla(Personaje personaje) {
		if(!muertoBoss) {
			System.out.println(personaje.getNombre() + " Entra a la Fortaleza");
			boolean muertoPersonaje = false;
			do {
				pressAnyKeyToContinue();
				muertoBoss = personaje.atacar(this.boss);
				if (!muertoBoss) {
					muertoPersonaje = boss.atacar(personaje);
				}
				
			}while(!this.muertoBoss && !muertoPersonaje);
			
			if(muertoBoss) {
				System.out.println("!!!! " +  personaje.getNombre() + " !!!! HA MATADO AL JEFE FINALL");
				System.out.println( personaje.getNombre() + " HA SALVADO NUESTRO MUNDOOOOOO");
				System.out.println( personaje.getNombre() + " QUIEROOO UN HIJOOOOO TUYOO");
			}else {
				System.out.println("FIN DEL JUEGO PARA " +  personaje.getNombre() + "\n");
			}
			
		}else {
			System.out.println(personaje.getNombre() + " Queria entrar a la fortaleza pero el Jefe Final ya murio");
		}

	}
	
	static public void pressAnyKeyToContinue(){
     
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("(Press Enter key to continue)");
        seguir = teclado.nextLine();
   }

	
}
