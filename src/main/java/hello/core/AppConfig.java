package hello.core;

import hello.core.caring.RateCaringPolicy;
import hello.core.creature.CreatureRepositoryAnimals;
import hello.core.creature.CreatureService;
import hello.core.creature.CreatureServiceImpl;
import hello.core.plan.PlanService;
import hello.core.plan.PlanServiceImpl;

public class AppConfig {

  public PlanService planService() {
    return new PlanServiceImpl(getCreatureRepository(), getCaringPolicy());
  }

  public CreatureService creatureService() {
    return new CreatureServiceImpl(getCreatureRepository());
  }

  private RateCaringPolicy getCaringPolicy() {
    return new RateCaringPolicy();
  }

  private CreatureRepositoryAnimals getCreatureRepository() {
    return new CreatureRepositoryAnimals();
  }

}
