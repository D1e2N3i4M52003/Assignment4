package model;

import multiton.Valuable;

import java.util.ArrayList;

public class Deposit {
	private ArrayList<Valuable> valuables;

	public Deposit() {
		this.valuables = new ArrayList<>();
	}

	public synchronized void addValuable(Valuable valuable){
		valuables.add(valuable);
	}

	public synchronized void takeValuable(String type){
		for (int i = 0; i < valuables.size(); i++){
			if (valuables.get(i).equals(type)){
				valuables.remove(i);
			}
		}
	}

	public synchronized void takeNextAvailableValuable(){

	}


}
