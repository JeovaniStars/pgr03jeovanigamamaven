// Pacote: br.com.ifba.infrastructure.dao
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.infrastructure.util.JPAUtil; 
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDao<T extends PersistenceEntity, ID extends Serializable> implements GenericIDao<T, ID> {

    // Remova o @PersistenceContext, pois não estamos usando injeção do Spring
    protected EntityManager entityManager;
    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
        // Obtenha o EntityManager através do nosso utilitário
        this.entityManager = JPAUtil.getEntityManager();
    }

    // O resto da classe (save, delete, findById, findAll) continua igual, mas agora usando transações manuais
    @Override
    public T save(T entity) {
        T savedEntity = null;
        try {
            entityManager.getTransaction().begin();
            savedEntity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace(); // É bom tratar o erro de forma mais robusta
        }
        return savedEntity;
    }

    @Override
    public void delete(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
    
    // Métodos de busca não precisam de transação explícita
    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
    }
}