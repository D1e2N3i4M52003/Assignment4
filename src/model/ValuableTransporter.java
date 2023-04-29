package model;

import interfaces.Door;
import interfaces.TakeAccess;
import multiton.Valuable;
import singleton.Log;

import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable{

	private Deposit deposit;
	private Door door;
	public ValuableTransporter(Deposit deposit){
		this.deposit = deposit;
		this.door = new Guardsman(new TreasureRoom(2, 3));
	}

	@Override
	public void run() {
		ArrayList<Valuable> valuablesThatTransporterHas = new ArrayList<>();

		while(true){

			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			Random random = new Random();
			int randomNumber = random.nextInt(2, 5);
			try {
				for (int i = 0; i < randomNumber; i++){
					valuablesThatTransporterHas.add(deposit.takeValuable());
				}
				Log.getInstance().addLog("Valuable transporter has finished his work");

			}
			catch (IndexOutOfBoundsException exception){
				System.out.println("Valuable transported has taken" + randomNumber + " valuables from deposit. ERROR: " + exception.getMessage());
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			TakeAccess list = door.acquireWrite();
			for(int i = valuablesThatTransporterHas.size()-1; i > 0 ; i--){
				list.add(valuablesThatTransporterHas.get(i));
				valuablesThatTransporterHas.remove(i);
			}
			System.out.println("Valuable transporter has put " + randomNumber + " valuables into the treasure room");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
