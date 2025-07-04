package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable; // Importe Serializable
import java.util.List;

//                  A CORREÇÃO ESTÁ NESTA LINHA
//                  vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
public abstract class GenericDao<T extends PersistenceEntity, ID extends Serializable> implements GenericIDao<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public T save(T entity) {
        // O método merge lida tanto com a inserção (novo) quanto com a atualização (existente).
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        // Garante que a entidade está no estado "managed" antes de remover.
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        // Cria uma consulta JPQL para buscar todos os registros da entidade.
        return entityManager.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
    }
}