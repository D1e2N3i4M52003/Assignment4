package Test;

import model.Deposit;
import model.Mine;
import multiton.Valuable;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest
{
  private ArrayList<Valuable> valuables;

  private Deposit deposit;

  @BeforeEach void setUp()
  {
    valuables = new ArrayList<>();
    deposit = new Deposit();
  }

  /*
  Z: push a null string in a 5 element stack throws an exception
O: one push in a 1 element stack can be done
O: one push in a 5 element stack can be done
M: 3 push in a 5 element stack can be done
B: 5 element stack, number of push {5, 6}. The right boundary throws an exception the left don't.
E: (already tested in Z and B)

   */

  @Test void addZero()
  {
    assertDoesNotThrow(()->deposit.addValuable());
  }

  @Test void addOne1()
  {
    valuables.add(Mine.mine());
    assertDoesNotThrow(()->deposit.addValuable());
  }

  @Test void addMany()
  {
    valuables.add(Mine.mine());
    valuables.add(Mine.mine());
    valuables.add(Mine.mine());
    deposit.addValuable();
    deposit.addValuable();
    assertDoesNotThrow(()->deposit.addValuable());
  }

  @Test void addBoundary()
  {
    // no boundary to be tested
  }

  @Test void addException()
  {
    // already tested in Z
  }

  /*
  Z: push a null string in a 5 element stack throws an exception
O: one push in a 1 element stack can be done
O: one push in a 5 element stack can be done
M: 3 push in a 5 element stack can be done
B: 5 element stack, number of push {5, 6}. The right boundary throws an exception the left don't.
E: (already tested in Z and B)

   */

  @Test void takeZero()
  {
    assertThrows(IndexOutOfBoundsException.class, ()->deposit.takeValuable());
  }

  @Test void takeOne1()
  {
    valuables.add(Mine.mine());
    deposit.addValuable();
    assertDoesNotThrow(()->deposit.takeValuable());
  }

  @Test void takeMany()
  {
    valuables.add(Mine.mine());
    valuables.add(Mine.mine());
    valuables.add(Mine.mine());
    deposit.addValuable();
    deposit.addValuable();
    deposit.addValuable();
    deposit.takeValuable();
    deposit.takeValuable();
    assertDoesNotThrow(()->deposit.takeValuable());
  }

  @Test void takeBoundary()
  {
    //already tested in Z
  }

  @Test void takeException()
  {
    // already tested in Z
  }
}
