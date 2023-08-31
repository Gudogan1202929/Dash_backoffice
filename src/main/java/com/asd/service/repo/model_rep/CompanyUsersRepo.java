package com.asd.service.repo.model_rep;

import com.asd.model.CompanyUsersModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyUsersRepo implements PanacheRepository<CompanyUsersModel> {
}
