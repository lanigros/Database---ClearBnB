package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Message;
import model.User;

public class MessageRepository {

  EntityManager entityManager;

  public MessageRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<Message> save(Message msg) {
    try {
      entityManager.getTransaction().begin();
      Message savedMsg = entityManager.merge(msg);
      entityManager.getTransaction().commit();
      return Optional.of(msg);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public List<Message> findAll(){
    return entityManager.createQuery("from Message", Message.class).getResultList();

  }

}
