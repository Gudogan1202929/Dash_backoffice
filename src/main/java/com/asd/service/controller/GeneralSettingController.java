package com.asd.service.controller;

import com.asd.model.GeneralSettingsModel;
import com.asd.service.repo.model_rep.GeneralSettingRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralSettingController {

    private final GeneralSettingRepo settingRepo = new GeneralSettingRepo();

    public List<GeneralSettingsModel> retrieveAllGeneralSetting() throws Exception {
        try {
            return settingRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
