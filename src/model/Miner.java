package model;

import multiton.Ore;
import multiton.Valuable;

public class Miner implements Runnable{

	private Deposit deposit;

	public Miner(Deposit deposit){
		this.deposit = deposit;
	}
	@Override
	public void run() {
		while(true){
			deposit.addValuable();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("A new valuable is added");
		}
	}
}
