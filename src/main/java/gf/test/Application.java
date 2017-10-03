package gf.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Iterable<ObjectMapper> objectMappers = SpringApplication.run(Application.class, args)
				.getBeansOfType(ObjectMapper.class)
				.values();

		Squiggly.init(objectMappers, new RequestSquigglyContextProvider());

	}

	@Bean
	public FilterRegistrationBean squigglyRequestFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new SquigglyRequestFilter());
		filter.setOrder(1);
		return filter;
	}
}
