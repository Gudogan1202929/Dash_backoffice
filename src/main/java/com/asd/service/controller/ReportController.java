package com.asd.service.controller;

import com.asd.model.ReportModel;
import com.asd.service.repo.model_rep.ReportRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportController {
    private final ReportRepo reportRepo = new ReportRepo();

    public List<ReportModel> RetrieveAllReportModels() throws Exception {
        try {
            return reportRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
