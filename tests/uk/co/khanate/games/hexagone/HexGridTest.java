/**
 * 
 */
package uk.co.khanate.games.hexagone;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author simon
 *
 */
public class HexGridTest {
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link uk.co.khanate.games.hexagone.Hex#HexGrid()}.
	 */
	// Test we can create the grid
	@Test
	public final void testHexGrid1() {
		HexGrid hexgrid = new HexGrid(3,3);
		assertNotNull( hexgrid );
	}
	
	// Test the Grid as default grid hexes
	@Test
	public final void testHexGrid2() {
		HexGrid hexgrid = new HexGrid(2,2);
		assertNotNull( hexgrid.getHexType(0,0) );
		assertEquals( Hex.hexTypes.X ,hexgrid.getHexType(0,0) );
		assertEquals( 1, hexgrid.getTileCount(0,0) );
	}

	// Test Basic Tile Adding
	@Test
	public final void testHexGrid3() {
		HexGrid hexgrid = new HexGrid(2,2);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		assertEquals( Hex.hexTypes.A ,hexgrid.getHexType(0,0) );
	}
	
	// Test Explosion 0x0 has 3 sides.
	@Test
	public final void testHexGrid4() {
		HexGrid hexgrid = new HexGrid(3,3);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		assertEquals( Hex.hexTypes.A ,hexgrid.getHexType(0,0) );
		assertEquals( 1, hexgrid.getTileCount(0, 0));	
		assertEquals( Hex.hexTypes.A ,hexgrid.getHexType(1,0) );
		assertEquals( 2, hexgrid.getTileCount(1, 0));
		assertEquals( Hex.hexTypes.X ,hexgrid.getHexType(2,2) );
		assertEquals( 1, hexgrid.getTileCount(2, 2));
	}
	
	@Test
	public final void testHexGrid5() {
		HexGrid hexgrid = new HexGrid(2,2);
		assertEquals( false, hexgrid.hasWon( Hex.hexTypes.A ) );
		assertEquals( false, hexgrid.hasWon( Hex.hexTypes.B ) );	
		boolean excepted = false;
		try {
			hexgrid.hasWon( Hex.hexTypes.X );
		} catch ( RuntimeException ex) {
			excepted = true;
		}
		assertTrue( excepted );
		hexgrid.addTile(0, 0, Hex.hexTypes.A);
		hexgrid.addTile(0, 0, Hex.hexTypes.A);
		hexgrid.addTile(0, 0, Hex.hexTypes.A);
		assertEquals( true, hexgrid.hasWon( Hex.hexTypes.A ) );		
		assertEquals( false, hexgrid.hasWon( Hex.hexTypes.B ) );		
	}	
	
	@Test
	public final void testHexGrid6() {
		HexGrid hexgrid = new HexGrid(2,2);

		boolean excepted = false;
		try {
			hexgrid.possibleMoves( Hex.hexTypes.X );
		} catch ( RuntimeException ex) {
			excepted = true;
		}
		assertTrue( excepted );
		int[][] poss = hexgrid.possibleMoves( Hex.hexTypes.A );
		assertArrayEquals( new int[] { 0,0 }, poss[0] );
		hexgrid.addTile(0, 0, Hex.hexTypes.B );
		hexgrid.addTile(0, 1, Hex.hexTypes.B );
		hexgrid.addTile(1, 0, Hex.hexTypes.B );
		poss = hexgrid.possibleMoves( Hex.hexTypes.A );
		assertArrayEquals( new int[] { 1,1 }, poss[0] );
		
	}
	
}

