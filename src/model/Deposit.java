package model;

import multiton.Ore;
import multiton.Valuable;

import java.util.ArrayList;

public class Deposit {
	private ArrayList<Valuable> valuables;

	public Deposit() {
		this.valuables = new ArrayList<>();
	}

	public synchronized void addValuable(){
		valuables.add(Mine.mine());
	}

	public synchronized void takeValuable(){
		valuables.remove(valuables.size()-1);
	}
}
