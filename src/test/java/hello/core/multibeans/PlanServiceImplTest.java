package hello.core.multibeans;

import hello.core.AutoAppConfig;
import hello.core.plan.PlanService;
import hello.core.plan.PlanServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlanServiceImplTest {

  @Test
  @DisplayName("Autowired로 조회 시, 같은 타입의 빈이 2개 이상이면 에러")
  void twoBeansOfCaringPolicy() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    ac.getBean(PlanServiceImpl.class);
  }
}
