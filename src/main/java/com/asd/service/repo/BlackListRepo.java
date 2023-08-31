package com.asd.service.repo;

import com.asd.model.BlackListModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.Query;

import java.util.List;

public class BlackListRepo implements PanacheRepository<BlackListModel>{

    public boolean findByToken(String token) {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM black_tokens WHERE black_token = ?", BlackListModel.class);
        query.setParameter(1, token);
        List<BlackListModel> resultList = query.getResultList();
        if (resultList.size() == 0){
            return true;
        }
        return false;
    }
}
