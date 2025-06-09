public class Militar extends Aeronave{
	public static final int PRIORIDAD = 2;

	public Militar(String id){
		super(id);
	}

	public int getPrioridad(){
		return PRIORIDAD;
	}

	public String toString(){
		return " ( Aeronave militar: " + super.toString() + " , Prioridad: " + PRIORIDAD + " ) ";
	}
}
