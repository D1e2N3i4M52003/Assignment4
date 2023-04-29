package model;

import multiton.Ore;
import multiton.Valuable;
import singleton.Log;

import java.util.ArrayList;
import java.util.Random;

public class Deposit {
	private ArrayList<Valuable> valuables;
	private Log log;

	public Deposit() {
		this.valuables = new ArrayList<>();
	}

	public synchronized void addValuable(){
		valuables.add(Mine.mine());
	}

	public synchronized Valuable takeValuable(){
		return valuables.remove(valuables.size()-1);
	}

	public int getSizeOfValuables(){
		return valuables.size();
	}
}
