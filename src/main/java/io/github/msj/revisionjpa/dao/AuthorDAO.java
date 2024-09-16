package io.github.msj.revisionjpa.dao;

import io.github.msj.revisionjpa.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Transactional
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Transactional
    public void delete(UUID id) {
        entityManager.remove(this.entityManager.getReference(Author.class, id));
    }
}
