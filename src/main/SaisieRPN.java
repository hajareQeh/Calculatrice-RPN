package main;

import java.util.Scanner;

import main.Exceptions.RpnException;
import main.Exceptions.DivException;
import main.Exceptions.ExpressionException;

public class SaisieRPN {

	private MoteurRPN m;

	public SaisieRPN() {
		m = new MoteurRPN();
	}

	public boolean isOperande(String operande)
	{
		try {
			Double value = Double.parseDouble(operande);
		} catch ( Exception e ) {
			return false;
		}
		return true;
	}


	public Operation getOperation(String op){
		switch ( op ) {
		case "+" : return Operation.PLUS;
		case "-" : return Operation.MOINS;
		case "*" : return Operation.MULT;
		case "/" : return Operation.DIV;
		default : return null;
		}
	}

	public boolean isOperation(String op){
		if ( op.equals("-") || op.equals("+") || op.equals("/") || op.equals("*")  ) return true;
		return false;
	}

	//delete the last operand added 
	public boolean deleteLast(String op){
		if ( op.equals("S")|| op.equals("s") || op.equals("supprimer") ) return true;
		return false;
	}

	//new pile
	public boolean restart(String op){
		if ( op.equals( "c" ) || op.equals( "clean" ) ||op.equals( "C" ) ) return true;
		return false;
	}

	public void lire() throws   RpnException, DivException, ExpressionException 
	{
		Scanner clavier = new Scanner(System.in); 

		do{
			System.out.print( "Entrez un nombre ou une operation : " );
			String chaine = clavier.nextLine();

			if ( isOperande(chaine) )
				m.empiler(Double.parseDouble(chaine));

			else if ( restart(chaine) ) 
				m = new MoteurRPN();	

			else if ( deleteLast(chaine) ) 
				m.depile();

			else if ( isOperation(chaine) )
				m.Calculer(getOperation(chaine));

			else throw new ExpressionException();

			System.out.println( "\nLA PILE : "+m.getPile() );

		}while(true) ;


	}

	public MoteurRPN getMoteur() {
		return m;
	}
}
