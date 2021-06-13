package hello.core.caring;

import hello.core.creature.Creature;
import hello.core.creature.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateCaringPolicyTest {

  RateCaringPolicy rateCaringPolicy = new RateCaringPolicy();

  @Test
  @DisplayName("멸종위기종의 경우 rate 적용")
  void endangered() {
    Creature creature = new Creature(1L, "rhinoceros", 5000, Grade.ENDANGERED);

    int totalExpense = rateCaringPolicy.totalExpense(creature, 100);

    Assertions.assertThat(totalExpense).isEqualTo(550000);
  }

  @Test
  @DisplayName("일반종의 경우 rate 미적용")
  void not_endangered() {
    Creature creature = new Creature(1L, "crocodile", 5000, Grade.NORMAL);

    int totalExpense = rateCaringPolicy.totalExpense(creature, 100);

    Assertions.assertThat(totalExpense).isEqualTo(500000);
  }
}
