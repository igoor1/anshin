package fatec.anshinpet;

import fatec.anshinpet.core.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AnshinpetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnshinpetApplication.class, args);
	}

}
