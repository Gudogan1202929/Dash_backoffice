package com.asd.service.controller;

import com.asd.model.MobileUsersModel;
import com.asd.service.repo.model_rep.MobileUserRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileUserController {
    private final MobileUserRepo mobileUserRepo = new MobileUserRepo();

    public List<MobileUsersModel> retrieveAllMobileUser() throws Exception {
        try {
            return mobileUserRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
