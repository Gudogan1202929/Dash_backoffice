package com.asd.service.reso;

import com.asd.service.controller.RulesController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.RulesRes)
public class RulesRes {

    private final RulesController rulesController = new RulesController();

    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRules() {
        try {
            return Response.ok(rulesController.retrieveAllRules()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
