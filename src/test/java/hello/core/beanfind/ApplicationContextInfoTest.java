package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.creature.CreatureService;
import hello.core.creature.CreatureServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

  ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      Object bean = ac.getBean(beanDefinitionName);
      System.out.println("beanDefinitionName = " + beanDefinitionName + "/" + "bean = " + bean);
    }
  }

  @Test
  @DisplayName("단일 빈 조회")
  void findBean() {
    Object creatureService1 = ac.getBean("creatureService");
    CreatureServiceImpl creatureService2 = ac.getBean(CreatureServiceImpl.class);
    CreatureService creatureService3 = ac.getBean("creatureService", CreatureService.class);

    System.out.println("creatureService1 = " + creatureService1);
    System.out.println("creatureService2 = " + creatureService2);
    System.out.println("creatureService3 = " + creatureService3);
  }

}
