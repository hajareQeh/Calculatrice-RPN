package main;

import main.Exceptions.DivException;
import main.Exceptions.RpnException;

public enum Operation {

	//----QUESTION 3.d-----
	PLUS("+")
	{
		@Override
		public Double Eval(Double opG, Double opD) { return opG + opD ; }
	},
	MOINS("-")
	{
		@Override
		public Double Eval(Double opG, Double opD) { return opG - opD ; }
	},
	MULT("*")
	{
		@Override
		public Double Eval(Double opG, Double opD) { return opG * opD ; }
	},
	DIV("/"){

		@Override
		public Double Eval(Double opG, Double opD) throws DivException {

			if ( opD == 0 ) throw new DivException();
			return opG / opD ;
		}

	};

	//----QUESTION 3.a-----
	private String symbole;

	//----QUESTION 3.b-----
	private Operation( String symbole ) {
		this.symbole = symbole;
	}

	//----QUESTION 3.c-----
	public abstract Double Eval(Double opG, Double opD) throws RpnException ;
}
