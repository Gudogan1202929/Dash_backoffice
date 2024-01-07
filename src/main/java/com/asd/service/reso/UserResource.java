package com.asd.service.reso;

import com.asd.model.BlackListModel;
import com.asd.model.JWTModel;
import com.asd.model.UserModel;
import com.asd.service.controller.UserController;
import com.asd.service.repo.BlackListRepo;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import com.asd.utils.enc.Encryption;
import com.asd.utils.jwt.CreatingJWT;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.USER_PATH)
public class UserResource {
    private static final UserController userController = new UserController();


    @POST
    @Transactional
    @Path(SystemPaths.LOGIN_PATH)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserModel userModel){
        try {
            boolean isUserExist = userController.login(userModel);
            JWTModel jwtModel = new JWTModel();
            if (isUserExist){
                String jwt = CreatingJWT.createJWT(userModel.getUsername(),SystemConstants.TOKEN_EXPIRATION_TIME);
                jwtModel.setJWTToken(jwt);
                System.out.println();
            }
            return Response.ok(jwtModel.getJWTToken()).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
