package hello.core.creature;

public interface CreatureService {

  void register(Creature creature);

  Creature findById(Long CreatureId);
}
