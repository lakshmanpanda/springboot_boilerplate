package com.sample.springboot_boilerplate.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserHandler {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Object[]> getGoal(Integer id) {
        StringBuilder query = new StringBuilder();
        query.append("select * from goals where assigned_to = :id ");

        Query nativeQuery = entityManager.createNativeQuery(query.toString());
        return nativeQuery.setParameter("id", id).getResultList();
    }

    public List<Object[]> getTaskList(Integer id, Integer gid) {
        StringBuilder query = new StringBuilder();
        query.append("select * from tasks where gid = :id ");

        Query nativeQuery = entityManager.createNativeQuery(query.toString());
        return nativeQuery.setParameter("id", id).getResultList();
    }
}
