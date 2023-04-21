package model;

import interfaces.EnterAccess;

public class ReadProxy implements EnterAccess {
  private TreasureRoom room;
  private Guardsman access;

  public ReadProxy(TreasureRoom room, Guardsman access) {
    this.room = room;
    this.access = access;
  }

  @Override public int count() {
    if (access.hasReadAccess(Thread.currentThread())) {
      if (room != null) {
        return room.count();
      }
      else
        throw new IllegalArgumentException("Null list!");
    }
    throw new IllegalArgumentException("Thread doesn't have access");
  }
}
