package repositoryinterface;

import java.util.Map;
import model.ActiveSession;

public interface ActiveSessionRepositoryInterface {

  public ActiveSession insertActiveSession(int userId, String sessionId);

  public void deleteActiveSessionById(String sessionId);

  public Map<String, Integer> getAllActiveSessions();

  public void deleteActiveSessionByUserId(int userId);

}
