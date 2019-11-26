package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Exceptions.*;
import main.*;


public class MoteurRPNTest {

	private MoteurRPN pile;

	@Before
	public void setUp() {
		pile = new MoteurRPN();
	}

	@Test(expected = MinValueException.class)
	public void StackValueLowerThanMinValueTest() throws RpnException {
		pile.empiler(-100000000);

	}

	@Test(expected = MaxValueException.class)
	public void StackValueBiggerThanMaxValueTest() throws RpnException {
		pile.empiler(100000000);

	}

	@Test(expected = StackException.class)
	public void unstackEmptyStackTest() throws RpnException {
		pile.depile();

	}
	
	@Test(expected = StackException.class)
	public void stackOnlyAnOperationTest() throws RpnException {
		pile.Calculer(Operation.PLUS);

	}


	@Test(expected = StackException.class)
	public void CalculWithAnOnlyOperandTest() throws RpnException 
	{
		pile.empiler(2);
		pile.Calculer(Operation.PLUS);
	}

	@Test
	public void PushTest() throws RpnException 
	{
		pile.empiler(10);
		pile.empiler(5);
		
		assertEquals((Double)5.0,(Double)pile.getPile().peek());

	}


	@Test
	public void PopTest() throws RpnException {
		pile.empiler(10);
		pile.empiler(5);

		assertEquals((Double)5.0,(Double)pile.depile());
	}

	@Test
	public void SimpleCalculTest() throws RpnException 
	{
		pile.empiler(10);
		pile.empiler(5);
		pile.Calculer(Operation.PLUS);
		
		assertEquals((Double)15.0,(Double) pile.getPile().lastElement());

	}

	@Test
	public void CalculWithManyOperandTest() throws RpnException 
	{
		pile.empiler(10);
		pile.empiler(5);
		pile.empiler(2);
		pile.empiler(3);
		
		pile.Calculer(Operation.PLUS);
		pile.Calculer(Operation.PLUS);
		pile.Calculer(Operation.PLUS);
		
		Double size = (double) pile.getStackSize();
		
		assertEquals((Double)1.0,(Double)size);

	}


}
