package tictactoe;
//An object type containing both indexes of a square in the game layout
public class Position { 
	private int i;
	private int j;
	public Position(int i, int j){
		this.i = i;
		this.j = j;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}

}
