public class Emergencia extends Aeronave{
	public static final int PRIORIDAD = 1;

	public Emergencia(String id){
		super(id);
	}

	public int getPrioridad(){
		return PRIORIDAD;
	}
	
	public String toString(){
		return " ( Aeronave de emergencia: " + super.toString() + ", Prioridad: " + PRIORIDAD + " ) ";
	}
}
