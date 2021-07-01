package hello.core.xml;

import hello.core.AppConfig;
import hello.core.creature.CreatureServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class xmlAppContext {

    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        Assertions.assertThat(ac.getBean("creatureService")).isInstanceOf(CreatureServiceImpl.class);
    }

}
