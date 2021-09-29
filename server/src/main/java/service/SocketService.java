package service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Message;
import repository.MessageRepository;
import utility.ManagerFactory;

public class SocketService {

  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final MessageRepository messageRepository = new MessageRepository(entityManager);

  public SocketService() {
  }

  public Optional<Message> saveMessage(Message msg) {
    Optional<Message> savedMsg = messageRepository.save(msg);
    if (savedMsg.isEmpty()) {
      return Optional.empty();
    }
    return savedMsg;
  }

  public List<Message> getAll(){
    return messageRepository.findAll();
  }

  public Message returnErrorMsg(){
    return new Message("Server", "Something went wrong, try again.");
  }
}


