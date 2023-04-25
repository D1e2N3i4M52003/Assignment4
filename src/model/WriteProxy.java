package model;

import interfaces.TakeAccess;
import multiton.Valuable;

public class WriteProxy implements TakeAccess {
  private TreasureRoom room;
  private Guardsman access;

  public WriteProxy(TreasureRoom room, Guardsman access) {
    this.room = room;
    this.access = access;
  }

  @Override public int count() {
    if (access.hasReadAccess(Thread.currentThread())) {
    if (room != null) {
      return room.count();
    }
    else throw new IllegalArgumentException("Null list!");
    }
    throw new IllegalArgumentException("Thread doesn't have access");
  }

  @Override public Valuable take() {
    if (access.hasWriteAccess(Thread.currentThread())) {
      if (room != null) {
        return room.take();
      }
      else throw new IllegalArgumentException("Null list!");
    }
    else
      throw new IllegalArgumentException("Thread doesn't have access");
  }
  @Override public void add(Valuable value) {
    if (access.hasWriteAccess(Thread.currentThread())) {
      if (room != null) {
        room.add(value);
      }
      else throw new IllegalArgumentException("Null list!");
    }
    else
      throw new IllegalArgumentException("Thread doesn't have access");
  }

}
