package com.asd.service.reso;

import com.asd.service.controller.CompanyTransReportController;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.CompanyTransReportRes)
public class CompanyTransReportRes {

    private final CompanyTransReportController companyTransReportController = new CompanyTransReportController();

    @Path(SystemPaths.RetrieveAll)
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompanyTransReport() {
        try {
            return Response.ok(companyTransReportController.retrieveAllCompanyTransReport()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
