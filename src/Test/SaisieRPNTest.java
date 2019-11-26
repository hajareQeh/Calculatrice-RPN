package Test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.*;


public class SaisieRPNTest {
	
	private SaisieRPN calculatrice;

	@Before
	public void setUp() {
		calculatrice = new SaisieRPN();
	}
	
	@Test
	public void isOperandeTest() {
		assertEquals(true,calculatrice.isOperande( "13.3" ));
	}
	
	@Test
	public void GetOperationtest() {
		assertEquals(Operation.PLUS,calculatrice.getOperation( "+" ) );
	}
	
	@Test
	public void isOperationTest() {
		assertEquals(true,calculatrice.isOperation( "+" ) );
	}
	
	@Test
	public void deleteLastTest() {
		assertEquals(true,calculatrice.deleteLast( "S" ));
	}
	
	@Test
	public void restartTest() {
		assertEquals(true,calculatrice.restart( "clean" ));
	}
	
}
