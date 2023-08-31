package com.asd.service.reso;

import com.asd.service.controller.CustomerRatingController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.CustomerRatingRes)
public class CustomerRatingRes {

    CustomerRatingController customerRatingController = new CustomerRatingController();

    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCustomerRating() {
        try {
            return Response.ok(customerRatingController.retrieveAllCustomerRatingModel()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
