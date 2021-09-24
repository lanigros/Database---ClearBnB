package repositoryinterface;

import java.util.Optional;
import model.Wallet;

public interface WalletRepositoryInterface {

public Wallet findByUserId(String userId);

  public Boolean findHasEnoughTokens(int price, int userId);
}
