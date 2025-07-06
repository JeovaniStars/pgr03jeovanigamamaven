// Pacote: br.com.ifba.infrastructure.util
package br.com.ifba.infrastructure.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "default"; // Verifique o nome no seu arquivo persistence.xml
    private static EntityManagerFactory factory;

    // Garante que a factory seja criada apenas uma vez
    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    // Método para obter um EntityManager
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    // Método para fechar a factory quando a aplicação terminar
    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}