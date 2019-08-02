package tw.com.leadteketl.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.com.leadtek.componet.WatchFile;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@ComponentScan("tw.com.leadteketl")
@EntityScan("tw.com.leadteketl.bean")
@EnableJpaRepositories("tw.com.leadteketl.dao")
public class DemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//new WatchFile().run();
	}
}
