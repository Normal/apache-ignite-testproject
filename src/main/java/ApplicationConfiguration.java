import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "service")
public class ApplicationConfiguration {

    @Bean
    public IgniteConfiguration igniteConfiguration(CacheConfiguration cache) {
        IgniteConfiguration conf = new IgniteConfiguration();
        conf.setCacheConfiguration(cache);

        return conf;
    }

    @Bean
    public CacheConfiguration cacheConfiguration() {
        CacheConfiguration cache = new CacheConfiguration();

        cache.setCacheMode(CacheMode.REPLICATED);

        return cache;
    }
}
