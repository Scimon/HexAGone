package uk.co.khanate.games.hexagone;

import java.util.ArrayList;

import uk.co.khanate.games.hexagone.Hex.hexTypes;


public class HexGrid {
	private Hex[][] grid; 
	private int sizeX;
	private int sizeY;
	private int[][] options = { { -1, -1 }, { -1,  0 }, {  0,  1 },
                                {  1,  1 }, {  1,  0 }, {  0, -1 } };
	
	public HexGrid( int x, int y ) {
		sizeX = x;
		sizeY = y;
		grid = new Hex[sizeX][sizeY];
		
		for ( int i = 0; i < sizeX; i++ ) {
			for ( int j = 0; j < sizeY; j++ ) {
				grid[i][j] = new Hex(i,j,calcSides(i,j));
			}
		}
	}
	
	private int calcSides( int x, int y ) {
		
		int count = 0;
		for ( int i = 0; i < options.length; i++ ) {
			int sx = x + options[i][0];
			int sy = y + options[i][1];
			if ( sx < sizeX && sy < sizeY && sx >= 0 && sy >= 0 ) {
				count++;
			}
		}
		
		return count;
	}
	
	private int[][] getSides( int x, int y ) {
		int count = calcSides(x,y);
		int[][] sides = new int [count][];

		int counter = 0;
		for ( int i = 0; i < options.length; i++ ) {
			int sx = x + options[i][0];
			int sy = y + options[i][1];
			if ( sx < sizeX && sy < sizeY && sx >= 0 && sy >= 0 ) {
				sides[counter] = new int[] { sx, sy };
			}
		}
		return sides; 
	}
	
	public Hex.hexTypes getHexType(int x, int y) {
		return grid[x][y].getType();
	}

	public void addTile(int x, int y, hexTypes t) {
		int explode = grid[x][y].addTile(t);
		if ( explode > 0 ) {
			ArrayList<int[]> targets = new ArrayList<int[]>();		
			int[][] newtargets = getSides(x,y);
			for ( int i = 0; i < newtargets.length; i++ ) {
				targets.add(newtargets[i]);
			}	
		
			while ( targets.size() > 0 ) {
				int[] location = targets.remove(0);
				explode = grid[location[0]][location[1]].addTile(t);
				if ( explode > 0 ) {
					newtargets = getSides(x,y);
					for ( int i = 0; i < newtargets.length; i++ ) {
						targets.add(newtargets[i]);
					}	
				}
			}
		}
	}

	public int getTileCount(int x, int y) {
		// TODO Auto-generated method stub
		return grid[x][y].tileCount();
	}
}
