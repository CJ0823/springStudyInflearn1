package hello.core.beanfind;

import hello.core.caring.CaringPolicy;
import hello.core.caring.FixedCaringPolicy;
import hello.core.caring.RateCaringPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상이면 에러")
    void findBeanByParentTypeDuplicate() {

        assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(CaringPolicy.class);
        });
    }

    @Configuration
    static class TestConfig {
        @Bean
        public CaringPolicy fixedCaringPolicy() {
            return new FixedCaringPolicy();
        }

        @Bean
        public CaringPolicy rateCaringPolicy() {
            return new RateCaringPolicy();
        }
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        assertThat(ac.getBean(RateCaringPolicy.class)).isInstanceOf(RateCaringPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상이면 빈 이름 지정")
    void findBeanByParentTypeBeanName() {
        assertThat(ac.getBean("fixedCaringPolicy", CaringPolicy.class)).isInstanceOf(FixedCaringPolicy.class);
    }
}
