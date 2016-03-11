package ignite

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("ignite")
class IgniteSampleAppApplication {

	static void main(String[] args) {
		SpringApplication.run IgniteSampleAppApplication, args
	}
}
