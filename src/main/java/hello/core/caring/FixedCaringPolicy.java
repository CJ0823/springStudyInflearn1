package hello.core.caring;

import hello.core.annotation.QulaifiedCaringPolicy;
import hello.core.creature.Creature;
import hello.core.creature.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@QulaifiedCaringPolicy
public class FixedCaringPolicy implements CaringPolicy{

  private int additionalExpense = 10000; //추가 비용

  @Override
  public int totalExpense(Creature creature, int expense) {

    int weight = creature.getWeight();

    if(creature.getGrade() == Grade.ENDANGERED) {
      return weight * expense + additionalExpense;
    } else {
      return weight * expense;
    }
  }
}
