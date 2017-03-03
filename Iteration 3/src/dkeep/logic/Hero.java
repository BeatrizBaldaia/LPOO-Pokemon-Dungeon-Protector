package dkeep.logic;

public class Hero extends Person{	

	public Hero(String name, int x, int y, char Ch){
		super(name,x,y, Ch);
	}
	
	public Hero(String name, int x, int y) {//construtor default
		this(name, x, y, 'H');
	}
	
	public void doStep (int x, int y) {
		prevX = this.x;
		prevY = this.y;
		this.x = x;
		this.y = y;
	}
}

