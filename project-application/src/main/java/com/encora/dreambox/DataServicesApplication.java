package com.encora.dreambox;

import com.encora.dreambox.dao.SchoolDao;
import com.encora.dreambox.dao.StudentDao;
import com.encora.dreambox.resources.SchoolResource;
import com.encora.dreambox.resources.StudentResource;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DataServicesApplication extends Application<DataServicesConfiguration> {

	public static void main(final String[] args) throws Exception {
		new DataServicesApplication().run(args);
	}

	private final ScanningHibernateBundle<DataServicesConfiguration> hibernate = new ScanningHibernateBundle<DataServicesConfiguration>(
			"com.encora.dreambox.core") {
		@Override
		public PooledDataSourceFactory getDataSourceFactory(DataServicesConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public String getName() {
		return "DataServices";
	}

	@Override
	public void initialize(final Bootstrap<DataServicesConfiguration> bootstrap) {
		bootstrap.addBundle(hibernate);
	}

	@Override
	public void run(final DataServicesConfiguration configuration, final Environment environment) {
		final SchoolDao schoolDao = new SchoolDao(hibernate.getSessionFactory());
		final StudentDao studentDao = new StudentDao(hibernate.getSessionFactory());
		final SchoolResource schoolResource = new SchoolResource(schoolDao);
		final StudentResource studentResource = new StudentResource(studentDao);
		environment.jersey().register(schoolResource);
		environment.jersey().register(studentResource);
	}
}
