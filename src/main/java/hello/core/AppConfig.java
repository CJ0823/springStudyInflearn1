package hello.core;

import hello.core.caring.RateCaringPolicy;
import hello.core.creature.CreatureRepositoryAnimals;
import hello.core.creature.CreatureService;
import hello.core.creature.CreatureServiceImpl;
import hello.core.plan.PlanService;
import hello.core.plan.PlanServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PlanService planService() {
        System.out.println("AppConfig.planService 호출");
        return new PlanServiceImpl(getCreatureRepository(), getCaringPolicy());
    }

    @Bean
    public CreatureService creatureService() {
        System.out.println("AppConfig.creatureService 호출");
        return new CreatureServiceImpl(getCreatureRepository());
    }

    @Bean
    public CreatureRepositoryAnimals getCreatureRepository() {
        System.out.println("AppConfig.getCreatureRepository 호출");
        return new CreatureRepositoryAnimals();
    }

    @Bean
    public RateCaringPolicy getCaringPolicy() {
        return new RateCaringPolicy();
    }

}
