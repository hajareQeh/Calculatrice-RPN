package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Operation;
import main.Exceptions.*;

public class OperationTest {

	private Double opG;
	private Double opD;

	@Before
	public void setUp() {
		opG = new Double(10);
		opD = new Double(5);
	}

	@Test
	public void AddTest() throws RpnException{
		assertEquals((Double)( opG + opD ),(Double)Operation.PLUS.Eval(opG, opD));
	}

	@Test
	public void SubTest() throws RpnException{
		assertEquals((Double)( opG - opD ),(Double)Operation.MOINS.Eval(opG, opD));
	}

	@Test
	public void MultTest() throws RpnException{
		assertEquals((Double)( opG * opD ),(Double)Operation.MULT.Eval(opG, opD));
	}

	@Test
	public void DivTest() throws RpnException{
		assertEquals((Double)( opG / opD ),(Double)Operation.DIV.Eval(opG, opD));
	}


	@Test(expected = DivException.class)
	public void divideByZero() throws RpnException {
		Operation.DIV.Eval(0.0, opD);

	}
}
