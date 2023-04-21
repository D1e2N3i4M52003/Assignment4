package model;

import interfaces.TakeAccess;

import java.util.ArrayList;

public class TreasureRoom implements TakeAccess {
  private ArrayList<Integer> list;
  private int secondsToCount;
  private int secondsToTake;

  public TreasureRoom(int secondsToCount,int secondsToTake){
    list = new ArrayList<>();
    this.secondsToCount = secondsToCount;
    this.secondsToTake = secondsToTake;
  }

  @Override public int count() {
    simulateThatItTakesTime(secondsToCount);
    return list.size();
  }

  @Override public void take(int value) {
    if(value<list.size())
    {
      for(int i=0;i<value;i++){
        list.remove(0);
      }
    }
    simulateThatItTakesTime(secondsToTake);
  }
  @Override public void add(int value) {
    if(value>0)
    {
      for(int i=0;i<value;i++){
        list.add(value);
      }
    }
    simulateThatItTakesTime(secondsToTake);
  }

  private void simulateThatItTakesTime(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    }
    catch (InterruptedException e) {/* empty*/ }
  }

}
