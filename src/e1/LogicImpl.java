package e1;

import java.util.*;

class LogicManager implements Logics {

	private final Pair<Integer,Integer> pawn;
	private final Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;

	 
    public LogicManager(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }

	//Nuovo costruttore per i test.
	public LogicManager(int size, Pair<Integer, Integer> pawnpos , Pair<Integer, Integer> knightpos )
	{
		this.size = size;
		this.pawn = pawnpos;
		this.knight = knightpos;
	}


	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

	//Spostato la responsabilità dell'Hit dentro alla classe WinLogic.
	@Override
	public boolean hit(int row, int col)
	{
		WinLogic win = new WinLogic(size, pawn, knight);
		return win.hit(row, col);
	}

	//Spostato la responsabilità del check delle posizioni dentro la classe "CheckPositionLogic".
	@Override
	public boolean hasKnight(int row, int col) {
		CheckPositionLogic pos = new CheckPositionLogic(pawn, knight);
		return pos.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		CheckPositionLogic pos = new CheckPositionLogic(pawn, knight);
		return pos.hasPawn(row, col);
	}
}


class WinLogic {

	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight; // per scopi di testing non può essere final.
	private final int size;

	public WinLogic(int size, Pair<Integer, Integer> pawnpos , Pair<Integer, Integer> knightpos)
	{
		this.size = size;
		this.pawn = pawnpos;
		this.knight = knightpos;
	}


	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

}

class CheckPositionLogic {
	private final Pair<Integer,Integer> pawn;
	private final Pair<Integer,Integer> knight;

	public CheckPositionLogic(Pair<Integer, Integer> pawnpos , Pair<Integer, Integer> knightpos)
	{
		this.pawn = pawnpos;
		this.knight = knightpos;
	}

	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
