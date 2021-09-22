package repositoryinterface;

import java.util.Map;
import model.ActiveSession;

public interface ActiveSessionRepositoryInterface {

  public ActiveSession insertActiveSession(int userId);

  public ActiveSession getActiveSession(int userId);

  public void deleteActiveSessionById(int sessionId);

  public Map<Integer, Integer> getAllActiveSessions();

}
