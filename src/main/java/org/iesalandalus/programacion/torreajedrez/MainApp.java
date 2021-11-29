package org.iesalandalus.programacion.torreajedrez;

//llamada a la biblioteca

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.torreajedrez.Torre;
import org.iesalandalus.programacion.torreajedrez.Direccion;
import org.iesalandalus.programacion.torreajedrez.Posicion;
import org.iesalandalus.programacion.torreajedrez.Color;

//creación de la clase principal
public class MainApp {
	//inicialización de variable
	private static Torre torre;
	
	public MainApp () {
		
	}

		public static void main(String[] args) {

			System.out.println("Programa para aprender a colocar y mover una torre en el tablero de ajedrez");
			mostrarMenu();
		}
		public void mostrarTorre() {
			
		}

		// Menú de ejecución
		private static void mostrarMenu() {

			System.out.println("- - - - - - - - - - MENU - - - - - - - - - -");
			System.out.println("1 - Crear una nueva Torre por defecto.");
			System.out.println("2 - Crear una nueva Torre con el color deseado.");
			System.out.println("3 - Crear una nueva Torre con el color y la columna inicial deseada.");
			System.out.println("4 - Mover la Torre.");
			System.out.println("5 - Realiza un enroque largo");
			System.out.println("6 - Realiza un enroque corto");
			System.out.println("7 - Salir.");
			ejecutarOpcion(elegirOpcion());
		}
		
		//iniciacilización de variables de opciones de mneu

		private static int elegirOpcion() {

			int seleccion;
			System.out.println("¿Que quieres hacer?");
			do {
				System.out.println("[Introduce un numero valido]");
				seleccion = Entrada.entero();
			} while (seleccion < 1 | seleccion > 7);
			return seleccion;
		}
		
		//Asignación de valores para cada variable, seleccion de sentencias para asignar cada caso a una opcion de menu

		private static void ejecutarOpcion(int seleccion) {

			switch (seleccion) {
			case 1:
				crearTorreDefecto();
				mostrarMenu();
				break;
			case 2:
				crearTorreDefectoColor();
				mostrarMenu();
				break;
			case 3:
				crearTorreColorPosicion();
				mostrarMenu();
				break;
			case 4:
				if (torre == null) {
					System.out.println("No se ha creado ninguna torre.");
					mostrarMenu();
				} else {
					mostrarMenuDirecciones();
				}
				break;
			case 5:
				System.out.println("Adios");
				System.exit(0);
				break;
			}
		}

		//Constructor de torre
		private static void crearTorreDefecto() {
			torre = new Torre();
			System.out.println("Se ha creado una nueva torre por defecto " + torre);
		}

		private static void crearTorreDefectoColor() {
			torre = new Torre(elegirColor());
			System.out.println("Se ha creado una nueva torre " + torre);
		}

		private static void crearTorreColorPosicion() {
			torre = new Torre(elegirColor(), elegirColumnaInicial());
			System.out.println("Se ha creado una nueva torre " + torre);
		}

		//parametros de las caracteristicas diferenciadores de la torre
		private static Color elegirColor() {
			int seleccion;
			Color color;
			System.out.println("¿De que color sera la torre?");
			System.out.println("1 - Negro.");
			System.out.println("2 - Blanco.");
			do {
				System.out.println("[Introduce un numero valido]");
				seleccion = Entrada.entero();
			} while (seleccion < 1 | seleccion > 2);
			if (seleccion == 1) {
				color = Color.NEGRO;
			} else {
				color = Color.BLANCO;
			}
			return color;
		}

		private static char elegirColumnaInicial() {
			int seleccion;
			char columna;
			System.out.println("¿En que columna comenzara el Torre?");
			System.out.println("1 - A ");
			System.out.println("2 - H ");
			do {
				System.out.println("[Introduce un numero valido]");
				seleccion = Entrada.entero();
			} while (seleccion < 1 | seleccion > 2);
			if (seleccion == 1) {
				columna = 'a';
			} else {
				columna = 'h';
			}
			return columna;
		}

		// Menú de movimiento de la torre

		private static void mostrarMenuDirecciones() {

			System.out.println("- - - - - - - - - - DIRECCIONES - - - - - - - - - -");
			System.out.println("1 - ARRIBA.");
			System.out.println("2 - DERECHA.");
			System.out.println("3 - ABAJO.");
			System.out.println("4 - IZQUIERDA.");
			System.out.println("5 - ENROQUE CORTO.");
			System.out.println("6 - ENROQUE LARGO.");

			mover();
		}
		//constructor de movimiento para describir la trayectoria de la torre

		private static Direccion elegirDireccion() {

			Direccion movimiento = null;
			int seleccion;

			System.out.println("¿Hacia donde quieres mover la torre?");
			do {
				System.out.println("[Introduce un numero valido]");
				seleccion = Entrada.entero();
			} while (seleccion < 1 | seleccion > 8);

			switch (seleccion) {
			case 1:
				movimiento = Direccion.ARRIBA;
				break;
			case 2:
				movimiento = Direccion.DERECHA;
				break;
			case 3:
				movimiento = Direccion.ABAJO;
				break;
			case 4:
				movimiento = Direccion.IZQUIERDA;
				break;
			case 5:
				movimiento = Direccion.ENROQUE_CORTO;
				break;
			case 6:
				movimiento = Direccion.ENROQUE_LARGO;
				break;
			}
			return movimiento;
		}

		private static void mover() {
			try {
				torre.mover(elegirDireccion());
				System.out.println("La torre se ha movido " + torre);
				mostrarMenu();
			} catch (OperationNotSupportedException e) {
				System.out.println("ERROR: Movimiento no valido");

			}
			mover();
		}
}
