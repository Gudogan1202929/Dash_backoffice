package com.asd.service.controller;

import com.asd.model.CompanyCountReportModel;
import com.asd.service.repo.model_rep.CompanyCountReportRepo;
import com.asd.utils.constant.SystemConstants;

import java.util.List;

public class CompanyCountReportController {

    private final CompanyCountReportRepo companyCountReportRepo = new CompanyCountReportRepo();

    public List<CompanyCountReportModel> RetrieveAllCompanyCountReport() throws Exception {
        try {
            return companyCountReportRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
