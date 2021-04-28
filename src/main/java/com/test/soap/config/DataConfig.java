package com.test.soap.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.test.soap.services.AssociateServiceEndpoint;
import com.test.soap.services.MerchantServiceEndpoint;
import com.test.soap.services.ProductServiceEndpoint;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.test.soap.services")
@EnableJpaRepositories("com.test.soap.repository")
@PropertySource("classpath:database.properties")
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class DataConfig {

	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_USERNAME = "user";
	private static final String PROPERTY_PASSWORD = "password";
	private static final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_DLL = "hibernate.hbm2ddl.auto";

	@Autowired
	private Environment environment;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lfb.setPackagesToScan("com.test.soap.model");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(environment.getProperty(PROPERTY_URL));
		ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
		ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
		ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
		return ds;
	}

	private Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		properties.setProperty(PROPERTY_DLL, environment.getProperty(PROPERTY_DLL));
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus(LoggingFeature loggingFeature) {

		SpringBus cxfBus = new SpringBus();
		cxfBus.getFeatures().add(loggingFeature);

		return cxfBus;
	}

	@Bean
	public LoggingFeature loggingFeature() {
		LoggingFeature loggingFeature = new LoggingFeature();
		loggingFeature.setPrettyLogging(true);
		return loggingFeature;
	}

	@Bean
	public EndpointImpl endpointMerchantService(Bus bus, MerchantServiceEndpoint merchantServiceEndpoint) {
		EndpointImpl endpoint = new EndpointImpl(bus, merchantServiceEndpoint);
		endpoint.publish("/MerchantService");
		return endpoint;
	}

	@Bean
	public EndpointImpl endpointProductService(Bus bus, ProductServiceEndpoint productServiceEndpoint) {
		EndpointImpl endpoint = new EndpointImpl(bus, productServiceEndpoint);
		endpoint.publish("/ProductService");
		return endpoint;
	}
	@Bean
	public EndpointImpl endpointAssociateService(Bus bus, AssociateServiceEndpoint associateServiceEndpoint) {
		EndpointImpl endpoint = new EndpointImpl(bus, associateServiceEndpoint);
		endpoint.publish("/AssociateService");
		return endpoint;
	}
}
