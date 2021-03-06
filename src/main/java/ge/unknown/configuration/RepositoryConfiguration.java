package ge.unknown.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan(basePackages = {"ge.unknown.entities"})
@EnableJpaRepositories(basePackages = {"ge.unknown.dao"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
