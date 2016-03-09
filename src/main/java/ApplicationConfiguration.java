import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public IgniteConfiguration igniteConfiguration() {
        IgniteConfiguration configuration = new IgniteConfiguration();

        return configuration;
    }
}
