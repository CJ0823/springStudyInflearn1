package hello.core.plan;

import hello.core.annotation.QulaifiedCaringPolicy;
import hello.core.caring.CaringPolicy;
import hello.core.caring.FixedCaringPolicy;
import hello.core.caring.RateCaringPolicy;
import hello.core.creature.Creature;
import hello.core.creature.CreatureRepository;
import hello.core.creature.CreatureRepositoryAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PlanServiceImpl implements PlanService {

  private final CreatureRepository creatureRepository;
  private final CaringPolicy caringPolicy;

  @Autowired
  public PlanServiceImpl(CreatureRepository creatureRepository, @QulaifiedCaringPolicy CaringPolicy caringPolicy) {
    this.creatureRepository = creatureRepository;
    this.caringPolicy = caringPolicy;
  }

  @Override
  public Plan createPlan(Long creatureId, int expense) {

    Creature creature = creatureRepository.findById(creatureId);

    int totalExpense = caringPolicy.totalExpense(creature, expense);

    return new Plan(creatureId, expense, totalExpense);
  }
}
