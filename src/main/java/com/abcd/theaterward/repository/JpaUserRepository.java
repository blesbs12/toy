package com.abcd.theaterward.repository;

import com.abcd.theaterward.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public Users save(Users users) {
        em.persist(users);
        return users;
    }

    @Override
    public long dupe(String userId) {
        String jpql = "SELECT COUNT(users) " +
                "FROM Users users " +
                "WHERE users.userId = :userId";

        return em.createQuery(jpql, long.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public Users findById(String userId) {
        String jpql = "SELECT u FROM Users u"
                + "WHERE u.userId = :userId";

        return em.createQuery(jpql,Users.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
