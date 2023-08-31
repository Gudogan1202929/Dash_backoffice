package com.asd.service.controller;

import com.asd.model.CustomerRatingModel;
import com.asd.service.repo.model_rep.CustomerRatingRepo;
import com.asd.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRatingController {

    private final CustomerRatingRepo customerRatingRepo = new CustomerRatingRepo();

    public List<CustomerRatingModel> retrieveAllCustomerRatingModel() throws Exception {
        try {
            return customerRatingRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
