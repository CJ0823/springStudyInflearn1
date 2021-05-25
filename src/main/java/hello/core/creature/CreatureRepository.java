package hello.core.creature;

public interface CreatureRepository {

  void save(Creature creature);

  Creature findById(Long creatureId);
}
