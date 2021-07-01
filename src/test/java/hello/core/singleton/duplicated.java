package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.creature.CreatureService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

public class duplicated {

    AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName("요청시마다 객체 생성")
    void duplicated() {

        CreatureService creatureService1 = appConfig.creatureService();
    }
}
