package interfaces;

import multiton.Valuable;

public interface TakeAccess extends EnterAccess{
  Valuable take();
  void add(Valuable value);
}
