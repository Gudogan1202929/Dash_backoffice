package com.asd.utils.jwt;

import com.asd.model.UserModel;
import com.asd.service.repo.BlackListRepo;
import com.asd.service.repo.UserRepo;
import com.asd.utils.constant.SystemConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
import java.util.Date;

public class AnalysisJWT {

    private static final UserRepo userRepo = new UserRepo();
    public static final BlackListRepo blackListRepo = new BlackListRepo();

    public static boolean CheckJWTIfForUser(String jwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SystemConstants.THE_KEY_FOR_TOKEN.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(jwt);

            UserModel userModelFromDataBase =  userRepo.findByUsername(decodedJWT.getSubject());

            if (!decodedJWT.getSubject().equals(userModelFromDataBase.getUsername()) || !blackListRepo.findByToken(jwt)
                    || !jwt.equals(userModelFromDataBase.getToken())){
                return false;
            }
            Long expirationTime = decodedJWT.getClaim(SystemConstants.EXPIRED).asLong();
            long currentTime = System.currentTimeMillis() / 1000;
            return expirationTime > currentTime;
        }catch (Exception e){
            return false;
        }
    }

    public static String WhatRole(String jwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SystemConstants.THE_KEY_FOR_TOKEN.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(jwt);
            return decodedJWT.getClaims().get(SystemConstants.ROLE).asString();
        }catch (Exception e){
            return null;
        }
    }
}
