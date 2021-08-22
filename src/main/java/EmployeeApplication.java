 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 


@SpringBootApplication
@EnableCaching	
//@EnableResourceServer
//@EnableGlobalMethodSecurity(proPostEnabled =true)
//@EnableWebSecurity
//@ComponentScan(basePackages = "com.emp")
//@SpringBootApplication(scanBasePackages={"com.emp.controller","com.emp.dao","com.emp.entity","com.emp.repository"})
@ComponentScan({"com.emp.request,com.emp.dao"})
@EntityScan("com.emp.entity")
@EnableJpaRepositories("com.emp.repository")
public class EmployeeApplication extends SpringBootServletInitializer{
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployeeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
