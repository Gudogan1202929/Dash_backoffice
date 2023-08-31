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
            System.out.println(userModel.getUsername() + " " + userModel.getPassword());
            System.out.println(Encryption.Decrypt(userModel.getPassword()));
            boolean isUserExist = userController.login(userModel);
            JWTModel jwtModel = new JWTModel();
            if (isUserExist){
                String jwt = CreatingJWT.createJWT(userModel.getUsername(),SystemConstants.TOKEN_EXPIRATION_TIME);
                jwtModel.setJWTToken(jwt);
            }
            return Response.ok(jwtModel).build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    public static final BlackListRepo blackListRepo = new BlackListRepo();
}
