package model;

import interfaces.Door;

import java.util.Random;

public class ValuableTransporter implements Runnable{

	private Deposit deposit;
	private Door door;

	public ValuableTransporter(Deposit deposit){
		this.deposit = deposit;
	}

	@Override
	public void run() {
		while(true){

			Random random = new Random();
			int randomNumber = random.nextInt(50, 200);
			for (int i = 0; i < randomNumber; i++){
				deposit.takeValuable();
			}
			door.acquireWrite();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			System.out.println("An valuable was taken");
		}
	}
}
