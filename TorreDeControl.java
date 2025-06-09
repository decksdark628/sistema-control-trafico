import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TorreDeControl{
	private ArrayList<Aeronave> aterrPend;
	private ArrayList<Aeronave> despPend;
	private boolean pistaLibre;

	public TorreDeControl(){
		aterrPend = new ArrayList<>();
		despPend = new ArrayList<>();
		pistaLibre = true;
	}

	public boolean registrarAeronaveParaAterrizar(Aeronave a){
		if (a != null){
			if (!aterrPend.contains(a)){
				aterrPend.add(a);
				Collections.sort(aterrPend);
				return true;
			}
		}
		return false;
	}
	public boolean registrarAeronaveParaDespegue(Aeronave a){
		if (a != null){
			if (!despPend.contains(a)){
				despPend.add(a);
				Collections.sort(despPend);
				return true;
			}
		}
		return false;
	}
	public void procesarSiguienteEvento(){
		if (pistaLibre){
			if (aterrPend.isEmpty() && despPend.isEmpty()){
				System.out.println("No hay mas vuelos que simular");
			}
			else {
				System.out.println ("\n================ Estado de la pista ================");
				sleepFixedAmount(500);
				System.out.print("-  Preparando pista");
				printLoadingText();
				pistaLibre = false;
				if(!aterrPend.isEmpty()){
					System.out.print( "- " + aterrPend.get(0) + " esta aterrizando");
					printLoadingText();
					aterrPend.remove(0);
					ordenarCola(aterrPend);
					System.out.println("-  Aterrizaje realizado con exito");
				}
				else{
					System.out.print( "- " + despPend.get(0) + " esta despegando");
					printLoadingText();
					despPend.remove(0);
					ordenarCola(despPend);
					System.out.println("-  Despegue realizado con exito");
				}
				sleepFixedAmount(1500);
				System.out.print("-  Liberando pista");
				liberarPista();
				printLoadingText();
				System.out.println ("====================================================");
				sleepFixedAmount(500);
			}
		}
	}

	public void liberarPista(){
		pistaLibre = true;
	}

	private void ordenarCola(ArrayList<Aeronave> list){
		if(!list.isEmpty()){
			Collections.sort(list);
		}
	}

	public boolean hayVuelosPendientes(){
		if (aterrPend.isEmpty() && despPend.isEmpty())
			return false;
		else
			return true;
	}
	
	private void printLoadingText(){
		for(int i = 0; i<3; i++){
			sleepFixedAmount(550);
			System.out.print(".");
		}
		System.out.println();
	}

	private void sleepFixedAmount(int n){
		try{
			Thread.sleep(n);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	public ArrayList<Aeronave> getAterrPend() {
		return this.aterrPend;
	}

	public void setAterrPend(ArrayList<Aeronave> aterrPend) {
		this.aterrPend = aterrPend;
	}

	public ArrayList<Aeronave> getDespPend() {
		return this.despPend;
	}

	public void setDespPend(ArrayList<Aeronave> despPend) {
		this.despPend = despPend;
	}

	public boolean isPistaLibre() {
		return this.pistaLibre;
	}

	public boolean getPistaLibre() {
		return this.pistaLibre;
	}

	public void setPistaLibre(boolean pistaLibre) {
		this.pistaLibre = pistaLibre;
	}

}
