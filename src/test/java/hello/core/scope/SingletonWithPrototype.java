package hello.core.scope;

import hello.core.scope.PrototypeTest.PrototypeBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototype {

  @Test
  void SingletonClientUsePrototype() {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

    ClientBean clientBean1 = ac.getBean(ClientBean.class);
    assertThat(clientBean1.add()).isEqualTo(1);

    ClientBean clientBean2 = ac.getBean(ClientBean.class);
    assertThat(clientBean2.add()).isEqualTo(2);

  }

  static class ClientBean {

    private final PrototypeBean prototypeBean; //생성시점에 주입

    @Autowired
    public ClientBean(PrototypeBean prototypeBean) {
      this.prototypeBean = prototypeBean;
    }

    public int add() {
      prototypeBean.addCount();
      return prototypeBean.getCount();
    }
  }
}
