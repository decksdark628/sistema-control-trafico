public class Militar extends Aeronave{
	public static final int PRIORIDAD = 2;

	public String toString(){
		return super.toString() + ", Prioridad: " + prioridad;
	}
}
