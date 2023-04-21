package model;

import interfaces.Door;
import interfaces.EnterAccess;
import singleton.*;

public class Accountant implements Runnable{ // Accountant is a reader

	private Door door;
	public Accountant(Door door) {
		this.door = door;
	}
	@Override
	public void run() {
		while(true) {
			EnterAccess list = door.acquireRead();
			Log log = Log.getInstance();
			log.addLog(String.valueOf(list.count()));
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
