package hello.core.creature;

import hello.core.AppConfig;

public class CreatureApp {

  public static void main(String[] args) {

    Creature creature1 = new Creature(1L, "horse", 500, Grade.NORMAL);

    //변경 전
//    CreatureService creatureService = new CreatureServiceImpl();

    //변경 후
    AppConfig appConfig = new AppConfig();
    CreatureService creatureService = appConfig.creatureService();


    creatureService.register(creature1);

    Creature foundCreature = creatureService.findById(1L);

    String name = foundCreature.getName();
    System.out.println("name = " + name);

  }
}
