package kevin.backend288;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "kevin.backend288.dao")
@EntityScan(basePackages = "kevin.backend288.entities")
public class Backend288Application {
	public static void main(String[] args) {
		SpringApplication.run(Backend288Application.class, args);
	}
}
