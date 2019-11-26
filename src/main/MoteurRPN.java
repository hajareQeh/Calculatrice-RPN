package main;

import main.Exceptions.StackException;
import main.Exceptions.RpnException;
import main.Exceptions.MaxValueException;
import main.Exceptions.MinValueException;

import java.util.Stack;
import java.util.Vector;

public class MoteurRPN {


	private Stack<Double> pile;
	private final static int MIN_VALUE = -10000000;
	private final static int  MAX_VALUE = 10000000;

	public MoteurRPN() 
	{
		pile = new Stack<>();
	}

	public void empiler( double operande ) throws RpnException
	{
		if ( MIN_VALUE > operande ) throw new MinValueException();
		if ( MAX_VALUE < operande ) throw new MaxValueException();
		pile.push( operande );

	}

	public boolean isEmpty() 
	{
		return pile.empty();

	}

	public double depile() throws RpnException 
	{

		if ( pile.isEmpty() ) throw new StackException();
		return pile.pop() ;

	}



	public void Calculer( Operation op ) throws RpnException
	{
		Double opD,opG;
		if( getStackSize() < 2 )throw new StackException();

		opG = depile();
		opD = depile();
		pile.push( op.Eval(opG, opD) );

	}


	public int getStackSize() {
		return pile.size();
	}

	public Stack<Double> getPile() {
		return pile;
	}


}



