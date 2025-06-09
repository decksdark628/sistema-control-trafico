public class Carga extends Aeronave{
	public static final int PRIORIDAD = 4;

	public Carga(String id){
		super(id);
	}
	
	public int getPrioridad(){
		return PRIORIDAD;
	}
	
	public String toString(){
		return " ( Aeronave de carga: " + super.toString() + ", Prioridad: " + PRIORIDAD + " ) ";
	}
}
