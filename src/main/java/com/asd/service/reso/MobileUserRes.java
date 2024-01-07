package com.asd.service.reso;

import com.asd.model.MobileUsersModel;
import com.asd.service.controller.MobileUserController;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.MobileUserRes)
public class MobileUserRes {
    private final MobileUserController mobileUserController = new MobileUserController();
    @GET
    @Path(SystemPaths.RetrieveAll)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllMobileUser() {
        try {
            return Response.ok(mobileUserController.retrieveAllMobileUser()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @Transactional
    @POST
    @Path(SystemPaths.CreateMobileUserRes)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMobileUser (MobileUsersModel mobileUsersModel){
        try {
            return Response.status(Response.Status.CREATED).entity(mobileUserController.createMobileUser(mobileUsersModel)).build();
        } catch (Exception e) {
            System.out.println("shit");
            System.out.println(e.getMessage());
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @Transactional
    @PUT
    @Path(SystemPaths.UpdateMobileUserRes)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMobileUser (MobileUsersModel mobileUsersModel){
        try {
            return Response.status(Response.Status.ACCEPTED).entity(mobileUserController.updateMobileUser(mobileUsersModel)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @Transactional
    @DELETE
    @Path(SystemPaths.DeleteMobileUserRes)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMobileUser (@QueryParam("id") long id){
        try {
            return Response.status(Response.Status.ACCEPTED).entity(mobileUserController.deleteMobileUser(id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @Transactional
    @GET
    @Path(SystemPaths.RetrieveNumberUser)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response retrieveNumberUser (){
        try {
            return Response.status(Response.Status.OK).entity(mobileUserController.retrieveNumberUser()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
