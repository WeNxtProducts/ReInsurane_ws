/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllotmentServiceConfig {

	@Bean
	public AllotmentPersistent allotmentPersistence() {
		return new AllotmentJPAAdapter();
	}

	@Bean
	public AllotmentService allotmentService() {
		return new AllotmentServiceImpl(allotmentPersistence());
	}
}
