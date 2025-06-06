public class Pasajeros extends Aeronave{
	public static final int PRIORIDAD = 3;

	public Pasajeros(String id){
		super(id);
	}

	public int getPrioridad(){
		return PRIORIDAD;
	}

	public String toString(){
		return "  [ Aeronave de pasajeros: " + super.toString() + ", Prioridad: " + PRIORIDAD + " ]  ";
	}
}
