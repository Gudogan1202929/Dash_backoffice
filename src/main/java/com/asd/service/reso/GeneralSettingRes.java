package com.asd.service.reso;

import com.asd.model.GeneralSettingsModel;
import com.asd.service.controller.GeneralSettingController;
import com.asd.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(SystemPaths.GeneralSettingRes)
public class GeneralSettingRes {

    private final GeneralSettingController generalSettingController = new GeneralSettingController();

    @Path(SystemPaths.RetrieveAll)
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllGeneralSetting() {
        try {
            return Response.ok(generalSettingController.retrieveAllGeneralSetting()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
