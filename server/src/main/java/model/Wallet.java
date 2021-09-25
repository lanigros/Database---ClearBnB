package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
@NamedQueries({
    @NamedQuery(name = "Wallet.findByUserId", query = "SELECT w FROM Wallet w WHERE w.userId = :userId"),
    @NamedQuery(name = "Wallet.findHasEnoughTokens", query = "SELECT CASE WHEN w.tokenAmount >= :price THEN true ELSE false END AS tokenAmount FROM Wallet w WHERE w.userId = :userId"),
    @NamedQuery(name="Wallet.withdrawTokens", query="UPDATE Wallet w SET w.tokenAmount=w.tokenAmount - :tokenAmount WHERE userId = :userId")
}
)
public class Wallet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name="user_id")
  private int userId;
  @Column(name="token_amount")
  private int tokenAmount;

  public Wallet() {
  }

  public Wallet(int id, int userId, int tokenAmount) {
    this.id = id;
    this.userId = userId;
    this.tokenAmount = tokenAmount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getTokenAmount() {
    return tokenAmount;
  }

  public void setTokenAmount(int tokenAmount) {
    this.tokenAmount = tokenAmount;
  }

  @Override
  public String toString() {
    return "Wallet{" +
        "id=" + id +
        ", user_id=" + userId +
        ", tokenAmount=" + tokenAmount +
        '}';
  }
}
