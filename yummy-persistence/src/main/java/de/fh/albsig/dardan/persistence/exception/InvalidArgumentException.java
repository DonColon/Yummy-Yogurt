package de.fh.albsig.dardan.persistence.exception;

public class InvalidArgumentException extends Exception
{

	private static final long serialVersionUID = -1723613564458614030L;


	public InvalidArgumentException()
	{
		super("This argument is not valid");
	}

	public InvalidArgumentException(final String message)
	{
		super(message);
	}

}
