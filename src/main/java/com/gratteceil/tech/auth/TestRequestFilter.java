package com.gratteceil.tech.auth;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;

public class TestRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Message message = JAXRSUtils.getCurrentMessage();
		AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
		System.out.println("Policy ::::::::: "+policy.getUserName()+" "+policy.getPassword());
	}

}
