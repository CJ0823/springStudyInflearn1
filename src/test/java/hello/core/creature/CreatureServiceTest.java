package hello.core.creature;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreatureServiceTest {

  //변경 전
//  CreatureService creatureService = new CreatureServiceImpl();


  //변경 후
  CreatureService creatureService;

  @BeforeEach
  void beforeEach() {
    AppConfig appConfig = new AppConfig();
    creatureService = appConfig.creatureService();
  }

  @Test
  @DisplayName("서비스 - register, findById 정상작동 테스트")
  void register() {

    //given
    Creature creature1 = new Creature(1L, "horse", 500, Grade.NORMAL);

    //when
    creatureService.register(creature1);

    //then
    Assertions.assertThat(creatureService.findById(1L).getName()).isEqualTo("horse");
  }
}
