package service;

import datatransforobject.UserCoreDTO;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.ActiveSession;
import repository.ActiveSessionRepository;
import utility.ManagerFactory;
import utility.Utility;

public class ActiveSessionService {
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "ActiveSession");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final ActiveSessionRepository activeSessionRepository = new ActiveSessionRepository(entityManager);
  private static Map<String, Integer> sessions;


  public ActiveSessionService(){
    sessions = activeSessionRepository.getAllActiveSessions();

  }

  public String createActiveSession(UserCoreDTO userCoreDTO) {
    ActiveSession activeSession = activeSessionRepository.insertActiveSession(
        userCoreDTO.getId(), Utility.createRandomAlphanumeric()
    );
    if(activeSession == null) return null;
    System.out.println("ActiveSessionService: " + activeSession.getId() + " " + userCoreDTO.getId());
    sessions.putIfAbsent(activeSession.getId(), userCoreDTO.getId());
    System.out.println("ActiveSessionService after put: " + sessions.get(activeSession.getId()));
    return activeSession.getId();
  }

  public void removeActiveSession(String sessionId){
    activeSessionRepository.deleteActiveSessionById(sessionId);
    sessions.remove(sessionId);
  }

  public int getActiveSessionUserId(String activeSessionId){
    return sessions.get(activeSessionId);
  }

  public static void addActiveSession(String sessionId, int userId){
    sessions.putIfAbsent(sessionId, userId);
  }
}
