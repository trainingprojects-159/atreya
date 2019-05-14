package com.mphasis.atreya.configurations;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.mphasis.atreya.entities.Admin;
import com.mphasis.atreya.entities.Appointment;
import com.mphasis.atreya.entities.Doctor;
import com.mphasis.atreya.entities.Feedback;
import com.mphasis.atreya.entities.LeaveReport;
import com.mphasis.atreya.entities.Patient;
import com.mphasis.atreya.entities.Reporter;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.mphasis.atreya.*")
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource getDatSource() { 
	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	ds.setUsername("Atreya");
	ds.setPassword("123");
	return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDatSource());
		sessionFactory.setPackagesToScan("com.mphasis.atreya.entities");
		sessionFactory.setAnnotatedClasses(Admin.class);
		sessionFactory.setAnnotatedClasses(Appointment.class);
		sessionFactory.setAnnotatedClasses(Doctor.class);
		sessionFactory.setAnnotatedClasses(Feedback.class);
		sessionFactory.setAnnotatedClasses(LeaveReport.class);
		sessionFactory.setAnnotatedClasses(Patient.class);
		sessionFactory.setAnnotatedClasses(Reporter.class);
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql","true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurerAdapter() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("HEAD","GET","POST","PUT","DELETE").allowedHeaders("Origin","X-Requested-With","Content-Type","Accept");
			}
		};
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManger(SessionFactory s) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(s);
		return hibernateTransactionManager;
	}
}
