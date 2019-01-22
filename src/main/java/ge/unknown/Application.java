package ge.unknown;

import ge.unknown.configuration.StorageConfiguration;
import ge.unknown.service.StorageService;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletException;
import java.util.Arrays;

@EnableConfigurationProperties(StorageConfiguration.class)
@SpringBootApplication
public class Application {

    @Autowired
    private StorageService serv;

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll(); // Delete all files on startup
            storageService.init();
        };
    }


    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                    Tomcat tomcat) {
                try {
                    Context root = tomcat.addWebapp("/uploads", serv.getRootLocation().toAbsolutePath().toString());
                    root.setAllowCasualMultipartParsing(true);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }

        };
    }
}