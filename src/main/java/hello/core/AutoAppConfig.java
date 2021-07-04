package hello.core;

import hello.core.creature.CreatureRepository;
import hello.core.creature.CreatureRepositoryAnimals;
import hello.core.creature.CreatureService;
import hello.core.creature.CreatureServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = {"hello.core"},
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

  @Bean(name = "creatureRepository")
  public CreatureRepository creatureRepository() {
    return new CreatureRepositoryAnimals();
  }
}
