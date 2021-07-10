package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.caring.CaringPolicy;
import hello.core.creature.Creature;
import hello.core.creature.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

  @Test
  void findAllBean() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, CaringService.class);

    CaringService caringService = ac.getBean(CaringService.class);
    Creature elephant = new Creature(1L, "elephant", 1000, Grade.ENDANGERED);
    int expense = caringService.expense(elephant, 10000, "fixedCaringPolicy");
    System.out.println("expense = " + expense);
  }

  static class CaringService {
    private final Map<String, CaringPolicy> caringPolicyMap;
    private final List<CaringPolicy> policies;

    @Autowired
    public CaringService(Map<String, CaringPolicy> caringPolicyMap, List<CaringPolicy> policies) {
      this.caringPolicyMap = caringPolicyMap;
      this.policies = policies;
      System.out.println("caringPolicyMap = " + caringPolicyMap);
      System.out.println("policies = " + policies);
    }

    public int expense(Creature creature, int price, String policy) {
      CaringPolicy caringPolicy = caringPolicyMap.get(policy);
      return caringPolicy.totalExpense(creature, price);
    }
  }
}
