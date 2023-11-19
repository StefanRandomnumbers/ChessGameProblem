
public class Position {
	public final int x;
	public final int y; 
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "\nx: " + this.x + "  y: " + this.y;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Position){
			Position obj = (Position)o;
			return (this.x == obj.x && this.y == obj.y);
		}
		return false;
	}
}
