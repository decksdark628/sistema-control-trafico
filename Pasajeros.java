public class Pasajeros extends Aeronave{
	public static final int PRIORIDAD = 3;

	public String toString(){
		return super.toString() + ", Prioridad: " + prioridad;
	}
}
