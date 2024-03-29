package com.asd.filter;

import com.asd.model.IPsModel;
import com.asd.model.RolesAndWhatAllowedModel;
import com.asd.service.repo.AccsessIPsRepoo;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.constant.SystemPaths;
import com.asd.utils.enc.Encryption;
import com.asd.utils.enc.Hash;
import com.asd.utils.jwt.AnalysisJWT;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterMethods {

    private static final AccsessIPsRepoo accsessIPsRepoo = new AccsessIPsRepoo();

    public static void filter(ContainerRequestContext containerRequestContext) {

        String ipAddress = containerRequestContext.getHeaderString(SystemConstants.IP_HEADER);
        String requestUri = containerRequestContext.getUriInfo().getRequestUri().toString();
        String authorization = containerRequestContext.getHeaderString(SystemConstants.TOKEN_NAME_ON_HEADER);

        boolean isAllowed = false;

        if (requestUri.contains(SystemPaths.LOGIN_PATH) && ipAddress != null) {

        } else if (AnalysisJWT.CheckJWTIfForUser(authorization) && ipAddress != null
                && requestUri != null) {

            String roleOfToken = null;
            if (authorization != null) {
                roleOfToken = AnalysisJWT.WhatRole(authorization);
            }

            List<RolesAndWhatAllowedModel> listOfRolls = new ArrayList<>();

            RolesAndWhatAllowedModel Admin = new RolesAndWhatAllowedModel(SystemConstants.ADMIN);
            Admin.getPaths().add("customer/rating/retrieve/all");
            Admin.getPaths().add("/");
            listOfRolls.add(Admin);

            RolesAndWhatAllowedModel User = new RolesAndWhatAllowedModel(SystemConstants.USER);
            listOfRolls.add(User);

            for (RolesAndWhatAllowedModel item : listOfRolls) {
                if (item.getRole().equalsIgnoreCase(roleOfToken)) {
                    for (String path : item.getPaths()) {
                        if (requestUri.contains(path)) {
                            isAllowed = true;
                            break;
                        }
                    }
                }
            }
            if (!isAllowed) {
                containerRequestContext.abortWith(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
            }

        } else {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        accsessIPsRepoo.persist(new IPsModel(ipAddress, currentDateTime.toString(), requestUri));
    }


    public static void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        int statusCode = containerResponseContext.getStatus();

        String message;

        switch (statusCode) {
            case 200:
                message = SystemConstants.OK;
                break;
            case 201:
                message = SystemConstants.CREATED;
                break;
            case 204:
                message = SystemConstants.NO_CONTENT;
                break;
            case 400:
                message = SystemConstants.BAD_REQUEST;
                break;
            case 401:
                message = SystemConstants.UNAUTHORIZED;
                break;
            case 403:
                message = SystemConstants.FORBIDDEN;
                break;
            case 404:
                message = SystemConstants.NOT_FOUND;
                break;
            case 405:
                message = SystemConstants.METHOD_NOT_ALLOWED;
                break;
            case 406:
                message = SystemConstants.NOT_ACCEPTABLE_MASSAGE;
                break;
            case 409:
                message = SystemConstants.CONFLICT;
                break;
            case 415:
                message = SystemConstants.UNSUPPORTED_MEDIA;
                break;
            case 500:
                message = SystemConstants.INTERNAL_SERVER_ERROR;
                break;
            case 503:
                message = SystemConstants.SERVER_UNAVAILABLE;
                break;
            case 504:
                message = SystemConstants.GATEWAY_TIMEOUT;
                break;
            case 505:
                message = SystemConstants.HTTP_VERSION_NOT_SUPPORT;
                break;
            case 507:
                message = SystemConstants.INSUFFICIENT_STORAGE;
                break;
            default:
                message = SystemConstants.UNKNOWN_STATUS_CODE + statusCode;
                break;
        }

        String entity = "";
        if ((statusCode == 200 || statusCode == 201 || statusCode == 202)) {
             entity = containerResponseContext.getEntity().toString();
        }else{
            try {
                entity = containerResponseContext.getEntity().toString();
                containerResponseContext.setEntity(statusCode + " : " + message + "\n" + entity);
            }catch (Exception e){
                containerResponseContext.setEntity(statusCode + " : " + message + "\n" + entity);
            }
        }
    }
}
