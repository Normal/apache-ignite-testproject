package ignite

import ignite.conf.IgniteContext
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@ComponentScan("ignite")
@Import(IgniteContext)
class IgniteSampleAppApplication {

	static void main(String[] args) {
		SpringApplication.run IgniteSampleAppApplication, args
	}
}
