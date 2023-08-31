package com.asd.service.controller;

import com.asd.model.CompanyUsersModel;
import com.asd.model.MobileUsersModel;
import com.asd.service.repo.model_rep.CompanyUsersRepo;
import com.asd.service.repo.model_rep.MobileUserRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyUsersController {
    private final CompanyUsersRepo companyUsersRepo = new CompanyUsersRepo();

    public List<CompanyUsersModel> retrieveAllCompanyUsers() throws Exception {
        try {
            return companyUsersRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
