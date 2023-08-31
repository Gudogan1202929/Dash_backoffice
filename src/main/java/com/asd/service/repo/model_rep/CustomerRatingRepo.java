package com.asd.service.repo.model_rep;

import com.asd.model.CustomerRatingModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRatingRepo implements PanacheRepository<CustomerRatingModel> {

}
