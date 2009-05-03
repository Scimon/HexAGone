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
public class HexTest {

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
	 * Test method for {@link uk.co.khanate.games.hexagone.Hex#Hex()}.
	 */
	@Test
	public final void testHex1() {
		Hex hex = new Hex(3);
		assertNotNull( hex );
		assertArrayEquals( new int[]{0,0}, hex.getLocation() );
		assertEquals( Hex.hexTypes.X, hex.getType() );
	}
	
	@Test
	public final void textHex2() {
		Hex hex = new Hex(1,1,3);
		assertNotNull( hex );	
		assertArrayEquals( new int[]{1,1}, hex.getLocation() );
		assertEquals( Hex.hexTypes.X, hex.getType() );
	}

	@Test
	public final void textHex3() {
		Hex hex = new Hex(1,1,3,Hex.hexTypes.A);
		assertNotNull( hex );	
		assertArrayEquals( new int[]{1,1}, hex.getLocation() );
		assertEquals( Hex.hexTypes.A, hex.getType()  );
	}

	@Test
	public final void textHex4() {
		Hex hex = new Hex(0,0,3);
		assertEquals( 1, hex.tileCount() );
		int explode = hex.addTile(Hex.hexTypes.B);
		assertEquals( 0, explode );
		assertEquals( 2, hex.tileCount() );
		assertEquals( Hex.hexTypes.B, hex.getType() );
		explode = hex.addTile(Hex.hexTypes.B);
		assertEquals( 0, explode );
		assertEquals( 3, hex.tileCount() );
		explode = hex.addTile(Hex.hexTypes.B);
		assertEquals( 3, explode );
		assertEquals( 1, hex.tileCount() );
	}
}


