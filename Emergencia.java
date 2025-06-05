public class Emergencia extends Aeronave{
	public static final int PRIORIDAD = 1;

	public String toString(){
		return super.toString() + ", Prioridad: " + prioridad;
	}
}
