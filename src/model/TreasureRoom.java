package model;

import interfaces.TakeAccess;
import multiton.Valuable;
import singleton.Log;

import java.util.ArrayList;

public class TreasureRoom implements TakeAccess {
	private ArrayList<Valuable> list;
	private int secondsToCount;
	private int secondsToTake;

	public TreasureRoom(int secondsToCount, int secondsToTake) {
		list = new ArrayList<>();
		this.secondsToCount = secondsToCount;
		this.secondsToTake = secondsToTake;
	}

	@Override
	public int count() {
		simulateThatItTakesTime(secondsToCount);
		return list.size();
	}

	@Override
	public Valuable take() {
		simulateThatItTakesTime(secondsToTake);
		return list.remove(0);
	}

	@Override
	public void add(Valuable value) {
		list.add(value);
		simulateThatItTakesTime(secondsToTake);
	}

	private void simulateThatItTakesTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {/* empty*/ }
	}
}

