package org.pwte.example.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/*
Microprofile healthcheck returns the following HTTPS Codes:

200 - if healthcheck status is UP
503 - if healthcheck status is DOWN 

*/

@ApplicationScoped
@Readiness
public class ReadinessCheck implements HealthCheck {
	
	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("Readiness").up().build();
	}

}
