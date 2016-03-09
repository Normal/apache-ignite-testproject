import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NodeStarter {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        IgniteConfiguration configuration = ctx.getBean(IgniteConfiguration.class);

        Ignition.start(configuration);
    }
}
