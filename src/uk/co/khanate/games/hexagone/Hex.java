/**
 * 
 */
package uk.co.khanate.games.hexagone;

/**
 * @author simon
 *
 */
public class Hex {
	public enum hexTypes { X, A, B };
	private hexTypes hexType;
	private int[] location;
	private int tileCount;
	private int tileSides;
	
	public Hex() {
		this(0,0,6,hexTypes.X);
	}
	
	public Hex(int sides) {
		this(0,0,sides,hexTypes.X);
	}
	
	public Hex( int newX, int newY, int sides ) {
		this(newX,newY,sides,hexTypes.X);
	}
	
	public Hex( int newX, int newY, int sides, hexTypes type ) {
		hexType = type;
		location = new int[2];
		location[0] = newX;
		location[1] = newY;
		tileCount = 1;
		tileSides = sides;
	}
	
	public int[] getLocation() {
		return location;
	}

	public hexTypes getType() {
		return hexType;
	}

	public int tileCount() {
		// TODO Auto-generated method stub
		return tileCount;
	}

	public int addTile(hexTypes type) {
		// TODO Auto-generated method stub
		tileCount++;
		hexType = type;
		if ( tileCount > tileSides ) {
			tileCount = 1;
			return tileSides;
		}
		return 0;
	}
	
}
