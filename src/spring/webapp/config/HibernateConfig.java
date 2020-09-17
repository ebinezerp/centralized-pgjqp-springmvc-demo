package spring.webapp.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.webapp.dto.User;

@Configuration
public class HibernateConfig {

	@Bean
	public SessionFactory getSessionFactory() {
		org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/springwebappdemo");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");

		config.setProperties(properties);
		config.addAnnotatedClass(User.class);
		return config.buildSessionFactory();
	}

}
