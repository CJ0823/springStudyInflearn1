package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulService {
  
  private int price; //상태를 유지하는 필드

  public int order(String name, int price) {
    System.out.println("name = " + name + "price = " + price);
//    this.price = price; //여기가 문제!
    return price;
  }

  public int getPrice() {
    return price;
  }

  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    //ThreadA: A 사용자가 10000원 주문
    int priceA = statefulService1.order("userA", 10000);
    //ThreadB: B 사용자가 20000원 주문
    statefulService1.order("userB", 20000);

    //ThreadA: A 사용자가 주문 금액 조회
//    int price = statefulService1.getPrice();
    System.out.println("priceA = " + priceA);
  }

  static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}
