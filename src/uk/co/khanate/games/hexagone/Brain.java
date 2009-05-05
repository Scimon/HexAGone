package uk.co.khanate.games.hexagone;

public class Brain {
	private Hex.hexTypes myType;
	
	public Brain( Hex.hexTypes t ) {
		myType = t;
	}
	
	public int[] makeMove( HexGrid g ) {
		int[][] possibles = g.possibleMoves(myType);
		return possibles[(int) Math.random() *  possibles.length];
	}
}
