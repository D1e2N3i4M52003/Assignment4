package readersWriters;

import java.util.Random;

public class King implements Runnable{ // King is a Writer
	private Door door;
	public King(Door door) {
		this.door = door;
	}

	@Override
	public void run() {
		while(true) {

			Random random = new Random();
			int rand = random.nextInt(5);

			TakeAccess list = door.acquireWrite();

			if (random < list.count()) {
					list.take(rand);
				try
				{
					Thread.sleep(10000);
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				}
				list.add(rand);
			}
			door.releaseWrite();

		}
	}
}
