package model;

public class ValuableTransporter implements Runnable{

	private Deposit deposit;

	public ValuableTransporter(Deposit deposit){
		this.deposit = deposit;
	}

	@Override
	public void run() {
		while(true){
			deposit.takeValuable();
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("An valuable was taken");
		}
	}
}
