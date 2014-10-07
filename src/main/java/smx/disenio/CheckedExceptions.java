package smx.disenio;

public class CheckedExceptions {

	public static interface Persistidor {
		void persistir(Object object);
	}

	public static class PersistidorEnDb implements Persistidor {

		public void persistir(Object object)
		// throws DbException
		{
			// ...
		}

	}

	public static class PersistidorIo implements Persistidor {

		public void persistir(Object object)
		// throws IOException
		{
			// ...
		}

	}

	@SuppressWarnings("serial")
	public static class DbException extends Exception {}

}
