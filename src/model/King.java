package model;

import interfaces.Door;
import interfaces.TakeAccess;
import multiton.Valuable;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable{ // King is a Writer
	private Door door;
	private ArrayList<Valuable> valuables;
	public King(Door door) {
		this.door = door;
		this.valuables = new ArrayList<>();
	}

	@Override
	public void run() {
		while(true) {

			Random random = new Random();
			int rand = random.nextInt(5);

			TakeAccess list = door.acquireWrite();

			if (rand < list.count()) {
				for(int i=0;i<rand;i++){
					valuables.add(list.take());
				}
				try
				{
					Thread.sleep(10000);
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
				for(int i=0;i<rand;i++){
					list.add(valuables.remove(0));
				}
			}
			door.releaseWrite();

		}
	}
}
