package com.asd.service.reso;

import com.asd.service.controller.ReportController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.ReportRes)
public class ReportRes {

    private final ReportController reportController = new ReportController();

    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllReport() {
        try {
            return Response.ok(reportController.RetrieveAllReportModels()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
