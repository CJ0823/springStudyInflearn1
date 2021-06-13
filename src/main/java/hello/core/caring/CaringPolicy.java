package hello.core.caring;

import hello.core.creature.Creature;

public interface CaringPolicy {

  /**
   *
   * @param creature
   * @param expense
   * @return 관리 비용
   */
  int totalExpense(Creature creature, int expense);
}
