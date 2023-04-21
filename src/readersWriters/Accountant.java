package readersWriters;

public class Accountant implements Runnable{ // Accountant is a reader

	private Door door;
	public Accountant(Door door) {
		this.door = door;
	}
	@Override
	public void run() {
		while(true) {
			EnterAccess list = door.acquireRead();
			list.count();
			LogLine logLine = new LogLine(list.count().toString());
			Log log = Log.getInstance();
			log.addToFile(logLine);
			door.releaseRead();
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
	}
}
