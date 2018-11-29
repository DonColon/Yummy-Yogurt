package de.fh.albsig.dardan.persistence.exception;


public abstract class ApplicationException extends Exception
{

	private static final long serialVersionUID = -5203015760897680L;


	public ApplicationException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public ApplicationException(final String message)
	{
		super(message);
	}

}
