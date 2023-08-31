package com.asd.service.repo;

import com.asd.model.IPsModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.springframework.stereotype.Repository;

@ApplicationScoped
public class AccsessIPsRepoo implements PanacheRepository<IPsModel> {
}
