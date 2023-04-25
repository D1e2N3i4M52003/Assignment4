import multiton.Valuable;
import singleton.Log;

import java.util.ArrayList;

public class Deposit
{
	private ArrayList<Valuable> valuables;
	private Log log;

	public Deposit() {
		this.valuables = new ArrayList<>();
	}

	public synchronized void addValuable(){
		valuables.add(Mine.mine());
		Log.getInstance().addLog("Miner is working");
	}

	public synchronized void takeValuable(){
		valuables.remove(valuables.size()-1);
		Log.getInstance().addLog("Valuable transporter is working");
	}
}
