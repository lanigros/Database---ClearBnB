package repository;

import model.Home;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class HomeRepository {

    private final EntityManager entityManager;

    public HomeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Optional<Home> findById(int id) {
        Home home = entityManager.find(Home.class, id);
        return home != null ? Optional.of(home) : Optional.empty();
    }
    public List<Home> findAll(){
        return entityManager.createQuery("from Home").getResultList();
    }
}
