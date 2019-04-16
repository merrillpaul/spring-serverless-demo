package com.merrill.boot.serverlessdemo.handler

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.merrill.boot.serverlessdemo.ServerlessdemoHandlerApp
import groovy.util.logging.Log4j

@Log4j
class LambdaHandler implements RequestStreamHandler {
	public static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler

	static {
		try {
			handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(ServerlessdemoHandlerApp)
		} catch (ContainerInitializationException e) {
			log.error("Could not initialize Spring Boot application")
			throw new RuntimeException("Could not initialize Spring Boot application", e)
		}
	}

	@Override
	void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		handler.proxyStream(input, output, context)
		output.close()
	}
}
