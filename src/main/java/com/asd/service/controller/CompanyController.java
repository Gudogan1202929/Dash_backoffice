package com.asd.service.controller;

import com.asd.model.CompanyModel;
import com.asd.service.repo.model_rep.CompanyRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyController {
    private final CompanyRepo companyRepo = new CompanyRepo();

    public List<CompanyModel> retrieveAllCompanies() throws Exception {
        try {
            return companyRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
