package readersWriters;

import java.util.ArrayList;

public class Guardsman implements Door{
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
    return null;
  }

  @Override public void releaseRead()
  {

  }

  @Override public TakeAccess acquireWrite()
  {
    return null;
  }

  @Override public void releaseWrite()
  {

  }
}
