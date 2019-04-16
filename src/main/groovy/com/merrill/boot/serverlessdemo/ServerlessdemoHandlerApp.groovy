package com.merrill.boot.serverlessdemo

import groovy.transform.Memoized
import groovy.util.logging.Log4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = "com.merrill.boot.serverlessdemo")
@Log4j
class ServerlessdemoHandlerApp extends SpringBootServletInitializer {

	static void main(String[] args) {
		SpringApplication.run(ServerlessdemoHandlerApp, args)
	}


	@Memoized
	ApplicationContext getApplicationContext(String[] args = []) {
		return main(args)
	}



}
