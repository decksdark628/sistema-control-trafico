public abstract class Aeronave implements Comparable<Aeronave>{
	private String id;

	public Aeronave(String id){
		this.id = id;
	}

	public int compareTo(Aeronave a){
		int comparison = 0;
		if (a != null){
			if(this.getPrioridad() > a.getPrioridad())
			comparison = 1;
			else if (this.getPrioridad() < a.getPrioridad())
				comparison = -1;
		}
		else
			comparison = -1;
		return comparison;
	}
	
	public abstract int getPrioridad();

	public String toString(){
		return ", ID: " + id;
	}
}
