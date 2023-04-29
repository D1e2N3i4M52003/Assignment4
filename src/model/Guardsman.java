package model;

import interfaces.Door;
import interfaces.*;
import model.ReadProxy;
import singleton.Log;

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
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
		Log.getInstance().addLog("Guardsman let someone read");
    }

    allowedReadAccess.add(Thread.currentThread());
    readers++;
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
	  Log.getInstance().addLog("Guardsman kicked the reader out");
  }

  @Override public TakeAccess acquireWrite()
  {
    waitingWriters++;

    while (readers > 0 || writers > 0)
    {
      try{
        wait();
      }
      catch (Exception e)
      {
        //
      }
		Log.getInstance().addLog("Guardsman let someone acquire the write");
    }
    allowedWriteAccess.add(Thread.currentThread());
    waitingWriters--; // writer preference
    writers++;
    return writeProxy;
  }

  @Override public void releaseWrite()
  {
    writers--;
    allowedWriteAccess.remove(Thread.currentThread());
    notifyAll(); // notify all waiting readers
	  Log.getInstance().addLog("Guardsman kicked the writer out");
  }
}
