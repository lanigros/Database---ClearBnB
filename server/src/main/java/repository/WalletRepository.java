package repository;

import javax.persistence.EntityManager;
import model.Wallet;

public class WalletRepository {
  private final EntityManager entityManager;

  public WalletRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Wallet findByUserId(String userId){
    return entityManager.createNamedQuery("Wallet.findByUserId", Wallet.class)
        .setParameter("userId", userId)
        .getSingleResult();
  }

  public Boolean tryTransaction(int price, int userId){
    entityManager.getTransaction().begin();
    boolean hasEnoughTokens = entityManager.createNamedQuery("Wallet.findHasEnoughTokens", Boolean.class)
       .setParameter("price", price)
       .setParameter("userId", userId)
       .getSingleResult();
    if(hasEnoughTokens) entityManager.createNamedQuery("Wallet.withdrawTokens")
        .setParameter("tokenAmount", price)
        .executeUpdate();
    entityManager.getTransaction().commit();
    return hasEnoughTokens;
  }

}
