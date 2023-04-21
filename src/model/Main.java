package model;

import model.Deposit;
import model.Miner;
import model.ValuableTransporter;

public class Main {
	public static void main(String[] args) {
		Deposit deposit = new Deposit();
		ValuableTransporter transporter = new ValuableTransporter(deposit);
		Miner miner = new Miner(deposit);

		Thread t1 = new Thread(miner);
		Thread t2 = new Thread(transporter);
		t1.start();
		t2.start();
	}
}
