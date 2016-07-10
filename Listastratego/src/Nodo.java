
public class Nodo {

	private int piece; //abbiamo bisogno di questo attributo per la ricerca per pezzi
	private int direction;
	private int x;
	private int y;
	private int countFoot;
	
	public Nodo next;
	
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCountFoot() {
		return countFoot;
	}
	public void setCountFoot(int countFoot) {
		this.countFoot = countFoot;
	}
	
	
	
}
