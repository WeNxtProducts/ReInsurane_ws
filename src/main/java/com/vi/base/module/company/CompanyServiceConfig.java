/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyServiceConfig {

	@Bean
	public CompanyPersistent companyPersistence() {
		return new CompanyJPAAdapter();
	}

	@Bean
	public CompanyService companyService() {
		return new CompanyServiceImpl(companyPersistence());
	}
}
