package com.asd.service.controller;

import com.asd.model.CompanyTransReportModel;
import com.asd.service.repo.model_rep.CompanyTransReportRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTransReportController {

    private final CompanyTransReportRepo companyTransReportRepo = new CompanyTransReportRepo();

    public List<CompanyTransReportModel> retrieveAllCompanyTransReport() throws Exception {
        try {
            return companyTransReportRepo.listAll();
        } catch (Exception e) {
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
