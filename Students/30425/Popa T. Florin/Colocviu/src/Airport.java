import java.awt.List;

public class Airport {
	
	List l = new List();
	Plane p = new Plane();

	public void receive(String plane){
		
		l.add(plane);
		
	}
	
	public void depart(String plane){
		
		l.add(plane);
		
	}
	
	
	public boolean inStation(boolean in){
		
		if(in){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
}
