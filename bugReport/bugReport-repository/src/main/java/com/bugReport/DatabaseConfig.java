/**
 ***************************************************************
 * Copyright(C) 2017 AUXENTA INC.
 * All rights reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF AUXENTA INC.
 * <p>
 * This copy of the Source Code is intended for AUXENTA INC's
 * internal use only and is intended for view by persons duly
 * authorized by the management of AUXENTA INC.
 * No part of this file may be reproduced or distributed in any form or by any
 * means without the written approval of the Management of AUXENTA INC.
 * <p>
 ***************************************************************
 */

package com.bugReport;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Contains database configurations.
 *
 * Created by prem on Oct 9, 2017.
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class DatabaseConfig {

	/** The env. */
	@Autowired
	private Environment env;

	/** The data source. */
	@Autowired
	private DataSource dataSource;

	/** The entity manager factory. */
	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	/**
	 * DataSource definition for database connection. Settings are read from the
	 * application.properties file (using the env object).
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	/**
	 * Declare the JPA entity manager factory.
	 *
	 * @return the local container entity manager factory bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource);

		// Classpath scanning of @Component, @Service, etc annotated class
		entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Vendor adapter
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		// additionalProperties.put("hibernate.hbm2ddl.auto",
		// env.getProperty("hibernate.hbm2ddl.auto"));
		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;
	}

	/**
	 * Declare the transaction manager.
	 *
	 * @return the jpa transaction manager
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}

	/**
	 * PersistenceExceptionTranslationPostProcessor is a bean post processor
	 * which adds an advisor to any bean annotated with Repository so that any
	 * platform-specific exceptions are caught and then rethrown as one Spring's
	 * unchecked data access exceptions (i.e. a subclass of
	 * DataAccessException).
	 *
	 * @return the persistence exception translation post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

} // class DatabaseConfig
