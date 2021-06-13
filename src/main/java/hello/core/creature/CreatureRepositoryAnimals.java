package hello.core.creature;

import java.util.HashMap;
import java.util.Map;

public class CreatureRepositoryAnimals implements CreatureRepository{

  private static Map<Long, Creature> store = new HashMap<>();

  @Override
  public void save(Creature creature) {
    store.put(creature.getId(), creature);
  }

  @Override
  public Creature findById(Long creatureId) {
    return store.get(creatureId);
  }
}
