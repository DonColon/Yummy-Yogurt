package de.fh.albsig.dardan.persistence.exception;

public class NoSuchRowException extends Exception
{

	private static final long serialVersionUID = 8794914178282421146L;

	public NoSuchRowException()
	{
		super("This element does not exist");
	}

	public NoSuchRowException(final String message)
	{
		super(message);
	}

}