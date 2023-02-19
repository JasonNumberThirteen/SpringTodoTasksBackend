package pl.jasonxiii.todotasksbackend;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoTasksBackendApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TodoTasksBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configure()
	{
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}