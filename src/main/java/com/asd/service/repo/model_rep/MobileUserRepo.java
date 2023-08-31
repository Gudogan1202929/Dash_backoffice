package com.asd.service.repo.model_rep;

import com.asd.model.MobileUsersModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MobileUserRepo implements PanacheRepository<MobileUsersModel> {

}
