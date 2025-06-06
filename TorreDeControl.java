import java.util.ArrayList;
import java.util.Collections;

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
				pistaLibre = false;
				if(!aterrPend.isEmpty()){
					System.out.println( "\n\t* " + aterrPend.get(0) + " esta aterrizando...");
					aterrPend.remove(0);
					ordenarCola(aterrPend);
				}
				else{
					System.out.println( "\n\t* " + despPend.get(0) + " esta despegando... ");
					despPend.remove(0);
					ordenarCola(aterrPend);
				}
				liberarPista();
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
		if (aterrPend.isEmpty() && aterrPend.isEmpty())
			return false;
		else
			return true;
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
