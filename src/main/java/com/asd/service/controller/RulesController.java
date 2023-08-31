package com.asd.service.controller;

import com.asd.model.RulesModel;
import com.asd.service.repo.model_rep.RulesRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RulesController {
    private final RulesRepo rulesRepo = new RulesRepo();

    public List<RulesModel> retrieveAllRules() throws Exception {
        try {
            return rulesRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
