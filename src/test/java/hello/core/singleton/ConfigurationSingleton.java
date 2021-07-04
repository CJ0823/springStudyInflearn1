package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.creature.CreatureRepositoryAnimals;
import hello.core.creature.CreatureService;
import hello.core.plan.PlanService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleton {

  ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("다른 클래스에 의해 만들어지는 인스턴스가 여러 번 생성됨")
  void NoSingleton() {
    CreatureService creatureService = ac.getBean(CreatureService.class);
    PlanService planService = ac.getBean(PlanService.class);
    CreatureRepositoryAnimals creatureRepositoryAnimals = ac.getBean(CreatureRepositoryAnimals.class);

  }
}
