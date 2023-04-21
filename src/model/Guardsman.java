package model;

import interfaces.Door;
import interfaces.*;
import model.ReadProxy;

import java.util.ArrayList;

public class Guardsman implements Door {
  //countkingaccountant takeking addvaluablertres
  private int readers;
  private int writers;
  private int waitingWriters;
  private ReadProxy readProxy;
  private WriteProxy writeProxy;
  private ArrayList<Thread> allowedReadAccess;
  private ArrayList<Thread> allowedWriteAccess;

  //write method add
  //king has method take

  public Guardsman(TreasureRoom valuablesList) {
      readers = 0;
      writers = 0;
      waitingWriters = 0;
    this.allowedReadAccess = new ArrayList<>();
    this.allowedWriteAccess = new ArrayList<>();
    this.readProxy =new ReadProxy(valuablesList, this);
    this.writeProxy = new WriteProxy(valuablesList, this);
  }
  public boolean hasReadAccess(Thread t) {
    return allowedReadAccess.contains(t);
  }
  public boolean hasWriteAccess(Thread t) {
    return allowedWriteAccess.contains(t);
  }

  @Override public EnterAccess acquireRead()
  {
    while (writers > 0 || waitingWriters > 0)
    {
      try
      {
        String txt = " WAIT (readers =" + readers + ", writers=" + writers + ")";
        System.out.println(Thread.currentThread().getName() + txt);

        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }

    allowedReadAccess.add(Thread.currentThread());
    readers++;
    String txt = " READING (readers =" + readers + ", writers=" + writers + ")";
    System.out.println(Thread.currentThread().getName() + txt);
    return readProxy;
  }

  @Override public void releaseRead()
  {

    readers--;
    if (readers== 0)
    {
      notify(); // notify one waiting writer
    }
    allowedReadAccess.remove(Thread.currentThread());
    String txt = " FINISHED READING (readers= "+ readers + ", writers=" + writers + ")";
    System.out.println(Thread.currentThread().getName() + txt);

  }

  @Override public TakeAccess acquireWrite()
  {
    waitingWriters++;

    while (readers > 0 || writers > 0)
    {
      try
      {
        String txt = " WAIT (readers= "+ readers + ", writers=" + writers + ")";
        System.out.println(Thread.currentThread().getName() + txt);
        wait();
      }
      catch (Exception e)
      {
        //
      }
    }
    allowedWriteAccess.add(Thread.currentThread());
    waitingWriters--; // writer preference
    writers++;
    String txt = " WRITING (readers= "+ readers + ", writers=" + writers + ")";
    System.out.println(Thread.currentThread().getName() + txt);
    return writeProxy;
  }

  @Override public void releaseWrite()
  {
    writers--;
    allowedWriteAccess.remove(Thread.currentThread());
    notifyAll(); // notify all waiting readers
    String txt = " FINISHED WRITING (readers= "+ readers + ", writers=" + writers + ")";
    System.out.println(Thread.currentThread().getName() + txt);
  }
}
