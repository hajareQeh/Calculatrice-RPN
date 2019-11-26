package main.Exceptions;

public class DivException extends RpnException{

	public DivException() {
		super( " Impossible de diviser par 0 " );
	}

}
