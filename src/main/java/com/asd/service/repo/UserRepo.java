package com.asd.service.repo;

import com.asd.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class UserRepo implements PanacheRepository<UserModel> {

    public UserModel findByUsername(String username) {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM user_table WHERE username = ?", UserModel.class);
        query.setParameter(1, username);
        List<UserModel> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            System.out.println("no1");
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public String AddToken(UserModel userModel ,String token) {
        String sql = "UPDATE user_table SET token = ? WHERE username = ? AND password = ? ";
        Query q = this.getEntityManager().createNativeQuery(sql);
        q.setParameter(1, token);
        q.setParameter(2, userModel.getUsername());
        q.setParameter(3, userModel.getPassword());
        int isDone = q.executeUpdate();

        if (isDone > 0){
            System.out.println(token);
            return token;
        }
        throw new RuntimeException("Token not added");
    }
}
