package hello.core.scope;

import hello.core.scope.PrototypeTest.PrototypeBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototype {

  @Test
  void SingletonClientUsePrototype() {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

    ClientBean clientBean1 = ac.getBean(ClientBean.class);
    assertThat(clientBean1.add()).isEqualTo(1);

    ClientBean clientBean2 = ac.getBean(ClientBean.class);
    assertThat(clientBean2.add()).isEqualTo(1);

  }

  static class ClientBean {

//    private final PrototypeBean prototypeBean; //생성시점에 주입
    private final Provider<PrototypeBean> prototypeBeanObjectProvider;

    @Autowired
    public ClientBean(Provider<PrototypeBean> prototypeBeanObjectProvider) {
      this.prototypeBeanObjectProvider = prototypeBeanObjectProvider;
    }

    public int add() {
      PrototypeBean prototypeBean = prototypeBeanObjectProvider.get();
      prototypeBean.addCount();
      return prototypeBean.getCount();
    }
  }
}
