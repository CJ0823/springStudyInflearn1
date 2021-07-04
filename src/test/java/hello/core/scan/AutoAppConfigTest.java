package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.creature.CreatureRepository;
import hello.core.creature.CreatureService;
import hello.core.plan.PlanService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

  @Test
  void basicScan() {

    CreatureService creatureService = ac.getBean(CreatureService.class);

    Assertions.assertThat(creatureService).isInstanceOf(CreatureService.class);
  }

  @Test
  void conflict() {
    ac.getBean(CreatureRepository.class);
  }

}
