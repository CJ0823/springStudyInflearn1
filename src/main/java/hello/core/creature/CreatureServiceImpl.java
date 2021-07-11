package hello.core.creature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatureServiceImpl implements CreatureService{

  private CreatureRepository creatureRepository;

  @Autowired
  public void init(CreatureRepository creatureRepository) {
    this.creatureRepository = creatureRepository;
  }

  @Autowired
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
