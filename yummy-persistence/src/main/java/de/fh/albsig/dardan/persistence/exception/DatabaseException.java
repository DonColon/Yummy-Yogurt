package de.fh.albsig.dardan.persistence.exception;


public class DatabaseException
{

	public static class NoSuchRow extends ApplicationException
	{
		private static final long serialVersionUID = -1458731752561826581L;

		public NoSuchRow(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public NoSuchRow(final String message)
		{
			super(message);
		}
	}

	public static class InvalidArgument extends ApplicationException
	{
		private static final long serialVersionUID = -8068823692854522796L;

		public InvalidArgument(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public InvalidArgument(final String message)
		{
			super(message);
		}
	}

}
