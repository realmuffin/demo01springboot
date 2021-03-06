package pe.opm.springboot.demo01.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"pe.opm.springboot.demo01.domain"})
@EnableJpaRepositories(basePackages = {"pe.opm.springboot.demo01.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
