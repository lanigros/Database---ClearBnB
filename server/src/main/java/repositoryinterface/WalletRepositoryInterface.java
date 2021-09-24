package repositoryinterface;

import java.util.Optional;
import model.Wallet;

public interface WalletRepositoryInterface {

public Wallet findByUserId(String userId);

  public Boolean tryTransaction(int price, int userId);
}
