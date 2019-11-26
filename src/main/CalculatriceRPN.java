package main;

import main.Exceptions.RpnException;

public enum CalculatriceRPN {

	CalculatriceRPN(){

	};

	private SaisieRPN calculatrice;

	CalculatriceRPN() 
	{

		calculatrice = new SaisieRPN();
		while(true) {
			try {
				calculatrice.lire();
			} catch ( RpnException e ) {
				System.out.println( e.getMessage() );
			}
		}

	} 

	public static void main(String[] args) {
		CalculatriceRPN e;



	}

}