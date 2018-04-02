package com.sierrica.config;


import org.springframework.context.annotation.Configuration;



//import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;
//import com.rollbar.notifier.Rollbar;
//import com.rollbar.notifier.config.Config;


//@Order(0)
@Configuration
public class Log {


	/*public Log (@Value("#{@environment['sentry.dsn']}") String sentryDsn) {
		Assert.notNull ("sentry.dsn",  "Property sentry.dsn' is required.");
		Sentry.init (sentryDsn);
	}*/

	
	
//	@Bean
//    public Rollbar rollbar(@Value("#{@environment['rollbar.key']}") String rollbarKey, ) {
//		Assert.notNull ("rollbar.key",  "Property rollbar.key' is required.");
//		Config config = withAccessToken(rollbarKey).environment("development").codeVersion("1.0.0").handleUncaughtErrors(true).build();
//		Rollbar rollbar = Rollbar.init(config);
//		rollbar.log("Hello, Rollbar");
//		return rollbar;
//	}
	
	
	/*@Bean
    public Bugsnag bugsnag(@Value("#{@environment['bugsnag.key']}") String bugsnagKey) {
		Assert.notNull ("bugsnag.key",  "Property bugsnag.key' is required.");
        
		// Create a Bugsnag client. False: not catch by default all exceptions, you need send explicitly.
        Bugsnag bugsnag = new Bugsnag(bugsnagKey, false);

        // Set some diagnostic data which will not change during the lifecycle of the application
        bugsnag.setReleaseStage("staging");
        bugsnag.setAppVersion("1.0.0");

        // Create and attach a simple Bugsnag callback. Use Callbacks to send custom diagnostic data which changes during the lifecyle of your application
//        bugsnag.addCallback((report) -> {
//            report.addToTab("diagnostics", "timestamp", new Date());
//            report.addToTab("customer", "name", "acme-inc");
//            report.addToTab("customer", "paying", true);
//            report.addToTab("customer", "spent", 1234);
//            report.setUserName("User Name");
//            report.setUserEmail("user@example.com");
//            report.setUserId("12345");
//        });
        
        //bugsnag.notify(new RuntimeException("PRUEBA"));

        return bugsnag;
    }*/
	
	
	
}