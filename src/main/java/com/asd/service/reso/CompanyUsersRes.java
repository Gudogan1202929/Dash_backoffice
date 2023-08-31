package com.asd.service.reso;

import com.asd.service.controller.CompanyUsersController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.CompanyUsersRes)
public class CompanyUsersRes {

    private final CompanyUsersController customerRatingController = new CompanyUsersController();

    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompanyUsers() {
        try {
            return Response.ok(customerRatingController.retrieveAllCompanyUsers()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
