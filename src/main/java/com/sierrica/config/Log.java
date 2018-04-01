
package com.sierrica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.sentry.Sentry;

@Configuration
public class Log {

	
	public Log (@Value("#{@environment['sentry.dsn']}") String sentryDsn) {
		Assert.notNull ("sentry.dsn",  "Property sentry.dsn' is required.");
		Sentry.init (sentryDsn);
	}
	

	
}