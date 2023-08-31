package com.asd.service.repo.model_rep;

import com.asd.model.ReportModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepo implements PanacheRepository<ReportModel> {
}
