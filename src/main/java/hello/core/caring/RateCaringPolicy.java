package hello.core.caring;

import hello.core.creature.Creature;
import hello.core.creature.Grade;

public class RateCaringPolicy implements CaringPolicy {

  private int rate = 10;

  @Override
  public int totalExpense(Creature creature, int expense) {

    int weight = creature.getWeight();
    int basicExpense = weight * expense;

    if(creature.getGrade() == Grade.ENDANGERED) {
      return basicExpense + basicExpense * rate / 100;
    } else {
      return basicExpense;
    }

  }
}
