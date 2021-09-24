package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import repository.WalletRepository;
import utility.ManagerFactory;

public class WalletService {

  private static final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Wallet");
  private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private static final WalletRepository walletRepository = new WalletRepository(entityManager);

  public static boolean tryTransaction(String priceString, String userIdString){
    int userId = Integer.parseInt(userIdString);
    int price = Integer.parseInt(priceString);
    return walletRepository.tryTransaction(price, userId);
  }

}
