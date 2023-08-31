package com.asd.service.reso;

import com.asd.service.controller.MobileUserController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.MobileUserRes)
public class MobileUserRes {
    private final MobileUserController mobileUserController = new MobileUserController();
    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllMobileUser() {
        try {
            return Response.ok(mobileUserController.retrieveAllMobileUser()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
