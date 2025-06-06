import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulador{
	ArrayList<Aeronave> aeronaves = new ArrayList<>();

	private void registrarNuevaAeronave(String id, int n){
		Aeronave ae = null;
		switch(n){
			case 1:
				ae = new Emergencia(id);
				break;
			case 2:
				ae = new Militar(id);
				break;
			case 3:
				ae = new Pasajeros(id);
				break;
			case 4:
				ae = new Carga(id);
				break;
			default:
				System.out.println("No es un tipo de aeronave valido");
		}
		aeronaves.add(ae);
	}

	private void enlistarAeronavesEnTorre(ArrayList<Aeronave> aeronaves, TorreDeControl torre, boolean aterrizaje){
		Iterator<Aeronave> iterator = aeronaves.iterator();
		String destino = "";

		if (aterrizaje)
			destino = "de aterrizajes";
		else
			destino = "de despegues";
		
		while (iterator.hasNext()){
			Aeronave a = iterator.next();
			boolean confirmacion = false;
			if (aterrizaje)
				confirmacion = torre.registrarAeronaveParaAterrizar(a);
			else
				confirmacion = torre.registrarAeronaveParaDespegue(a);
			if (confirmacion){
				System.out.println("> Se añadio la aeronave a la cola " + destino);
				iterator.remove();
			}
			else
				System.out.println("> No se pudo añadir a la cola" + destino);
		}
		if (!aeronaves.isEmpty()){
			System.out.println("(!) No se pudieron añadir todas las aeronaves a la cola.");
			if (askToDeleteList());
				aeronaves.clear();
		}
	}

	private boolean askToDeleteList(){
		Scanner sc = new Scanner(System.in);
			System.out.println("¿Desear limpiar la lista de todas formas? (y/n)");
			boolean accepts = false;
			boolean exit = false;
			while (!exit){
				String answer = sc.nextLine().toLowerCase().trim();
				if (answer != null){
					if (answer.equals("y"))
						accepts = true;
					else if (answer.equals("n"))
						accepts = false;
					else
						System.out.println("No es una opcion valida, intenta otra vez");
				}
			}
			sc.close();
			return accepts;

	}
	/* Opcion de añadir elementos a la torre de 1 en 1 */
	private void enlistarAeronavesEnTorre(Aeronave ae, TorreDeControl torre, boolean aterrizaje){
		String destino = "";

		if (aterrizaje)
			destino = "de aterrizajes";
		else
			destino = "de despegues";

		boolean confirmacion = false;
		if (aterrizaje)
			confirmacion = torre.registrarAeronaveParaAterrizar(ae);
		else
			confirmacion = torre.registrarAeronaveParaDespegue(ae);
		if (confirmacion){
			System.out.println("\nSe añadio la aeronave a la cola " + destino);

		}
		else
			System.out.println("\nNo se pudo añadir a la cola" + destino);
	}

	private void mostrarColas(TorreDeControl t){
		System.out.println("\nATERRISAJES PENDIENTES:");
		System.out.println(t.getAterrPend());
		System.out.println("\nDESPEGUES PENDIENTES:");
		System.out.println(t.getDespPend());
	}

	private void iniciarSimulacion(TorreDeControl torre){
		while(torre.hayVuelosPendientes()){
			mostrarColas(torre);
			torre.procesarSiguienteEvento();
		}
		System.out.println("\nNo hay vuelos por procesar");
	}

	public static void main(String[] args){
		Simulador sim = new Simulador();
		TorreDeControl torre = new TorreDeControl();

		sim.registrarNuevaAeronave("GN0M3", 3);
		sim.registrarNuevaAeronave("KD300", 1);
		sim.registrarNuevaAeronave("QT123", 2);

		sim.enlistarAeronavesEnTorre(sim.aeronaves, torre, true);

		torre.procesarSiguienteEvento();

		sim.registrarNuevaAeronave("0RGM0D", 4);
		sim.registrarNuevaAeronave("N30V1M", 4);

		sim.enlistarAeronavesEnTorre(sim.aeronaves, torre, false);

		sim.iniciarSimulacion(torre);
	}
}
