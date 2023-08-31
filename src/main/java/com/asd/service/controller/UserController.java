package com.asd.service.controller;

import com.asd.model.UserModel;
import com.asd.service.repo.UserRepo;
import com.asd.utils.constant.SystemConstants;
import com.asd.utils.enc.Encryption;
import com.asd.utils.enc.Hash;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Service;

public class UserController {
    private final UserRepo userRepo = new UserRepo();

    @Transactional
    public boolean login(UserModel userModel) throws Exception {
        try {
            String password = Encryption.Decrypt(userModel.getPassword());
            UserModel userModel1ByFind = userRepo.findByUsername(userModel.getUsername());
            if (Hash.hashing(password).equals(userModel1ByFind.getPassword())){
                return true;
            }
            throw new Exception(SystemConstants.CANNT_LOGIN);
        }catch (Exception e){
            throw new Exception(SystemConstants.CANNT_LOGIN);
        }
    }
}
