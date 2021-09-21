package repositoryinterface;

import model.ActiveSession;
import model.User;

public interface ActiveSessionRepositoryInterface {
  public int insertActiveSession(int userId);

  public ActiveSession getActiveSession(int userId);

  public void deleteActiveSessionByUserId(int userId);
}
