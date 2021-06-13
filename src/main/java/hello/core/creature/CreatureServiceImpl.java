package hello.core.creature;

public class CreatureServiceImpl implements CreatureService{

  private final CreatureRepository creatureRepository;

  public CreatureServiceImpl(CreatureRepository creatureRepository) {
    this.creatureRepository = creatureRepository;
  }

  @Override
  public void register(Creature creature) {
    creatureRepository.save(creature);
  }

  @Override
  public Creature findById(Long creatureId) {
    return creatureRepository.findById(creatureId);
  }
}
