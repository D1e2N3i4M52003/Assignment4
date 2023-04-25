import model.*;
import singleton.Log;

public class Main {
	public static void main(String[] args) {
		TreasureRoom treasureRoom = new TreasureRoom(1, 2);
		Guardsman guardsman = new Guardsman(treasureRoom);
		Deposit deposit = new Deposit();
		ValuableTransporter transporter = new ValuableTransporter(deposit);
		Miner miner = new Miner(deposit);

		Thread t1 = new Thread(miner);
		Thread t2 = new Thread(transporter);
		t1.start();
		t2.start();


	}
}
