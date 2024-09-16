package io.github.msj.revisionjpa.dao;

import io.github.msj.revisionjpa.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Author findById(UUID id) {
        return entityManager.find(Author.class, id);
    }

    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }

    @Transactional(readOnly = true)
    public List<Author> findByFirstNameOrLastName(String term) {
        return entityManager.createQuery("SELECT a FROM Author a WHERE a.firstName like :term OR a.lastName like :term")
                .setParameter("term", "%" + term + "%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long count() {
        return entityManager.createQuery("SELECT count(1) FROM Author a", Long.class).getSingleResult();
    }

}
