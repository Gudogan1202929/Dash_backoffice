package com.asd.filter;

import com.asd.model.CompanyModel;
import com.asd.service.repo.AccsessIPsRepoo;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class Filter implements ContainerRequestFilter, ContainerResponseFilter {
    @Transactional
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        FilterMethods.filter(containerRequestContext);
    }
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        FilterMethods.filter(containerRequestContext,containerResponseContext);
    }
}
