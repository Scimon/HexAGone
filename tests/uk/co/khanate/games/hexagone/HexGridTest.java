/**
 * 
 */
package uk.co.khanate.games.hexagone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		HexGrid hexgrid = new HexGrid(2,2);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		hexgrid.addTile(0,0,Hex.hexTypes.A);
		assertEquals( Hex.hexTypes.A ,hexgrid.getHexType(0,0) );
		assertEquals( 1, hexgrid.getTileCount(0, 0));	
		assertEquals( Hex.hexTypes.A ,hexgrid.getHexType(1,0) );
		assertEquals( 2, hexgrid.getTileCount(1, 0));
	}
	
	
}

