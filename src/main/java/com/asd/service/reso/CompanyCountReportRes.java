package com.asd.service.reso;

import com.asd.model.CompanyCountReportModel;
import com.asd.service.controller.CompanyCountReportController;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.CompanyCountReportRes)
public class CompanyCountReportRes {

    private final CompanyCountReportController companyCountReportController = new CompanyCountReportController();

    @Path(SystemPaths.RetrieveAll)
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompanyCountReport() {
        try {
            return Response.ok(companyCountReportController.RetrieveAllCompanyCountReport()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
