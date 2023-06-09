package interfaces;


public interface Door {
  EnterAccess acquireRead();
  void releaseRead();
  TakeAccess acquireWrite();
  void releaseWrite();
}
