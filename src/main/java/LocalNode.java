import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.Person;
import service.PersonService;

public class LocalNode {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        IgniteConfiguration configuration = ctx.getBean(IgniteConfiguration.class);
        PersonService service = ctx.getBean(PersonService.class);

        try (Ignite ignite = Ignition.start(configuration)) {
            IgniteCache<Integer, Person> cache = ignite.getOrCreateCache("cool cache");

            int i = 0;
            for(Person p: service.getAll()) {
                cache.put(i, p);
                i++;
            }

        }
    }
}
