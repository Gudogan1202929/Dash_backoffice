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

    public MobileUsersModel createMobileUser(MobileUsersModel mobileUsersModel) throws Exception {
        try {
            mobileUserRepo.persist(mobileUsersModel);
            return mobileUsersModel;
        } catch (Exception e) {
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public MobileUsersModel updateMobileUser(MobileUsersModel mobileUsersModel) throws Exception {
        try {
            MobileUsersModel mobileUsersModel1 = mobileUserRepo.findById(mobileUsersModel.getId());
            mobileUsersModel1.setActive(mobileUsersModel.isActive());
            mobileUsersModel1.setCity(mobileUsersModel.getCity());
            mobileUsersModel1.setCode(mobileUsersModel.getCode());
            if (mobileUsersModel.getCreation_date() != null || !mobileUsersModel.getCreation_date().equals("")){
                mobileUsersModel1.setCreation_date(mobileUsersModel.getCreation_date());
            }else {
                mobileUsersModel1.setCreation_date(mobileUsersModel1.getCreation_date());
            }
            mobileUsersModel1.setMobile_number(mobileUsersModel.getMobile_number());
            mobileUsersModel1.setName(mobileUsersModel.getName());
            mobileUserRepo.persist(mobileUsersModel1);
            return mobileUsersModel1;
        } catch (Exception e) {
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public Object deleteMobileUser(long id) {
        try {
            MobileUsersModel mobileUsersModel = mobileUserRepo.findById(id);
            if (mobileUsersModel == null) {
                return SystemConstants.BAD_REQUEST;
            }
            mobileUserRepo.delete(mobileUsersModel);
            return mobileUsersModel;
        } catch (Exception e) {
            return SystemConstants.BAD_REQUEST;
        }
    }

    public int retrieveNumberUser() throws Exception {
        try {
            List<MobileUsersModel> list = mobileUserRepo.listAll();
            return list.size();
        } catch (Exception e) {
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
