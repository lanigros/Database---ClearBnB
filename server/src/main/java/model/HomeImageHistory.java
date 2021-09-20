package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "home_image_history_log")
public class HomeImageHistory {

  @Id
  @GeneratedValue
  private int id;

  @JsonBackReference(value = "home-image-histories")
  @JoinColumn(name = "home_history_log_id")
  @ManyToOne
  private HomeHistoryLog homeHistoryLog;

  @Column(name = "image_url")
  private String imageUrl;

  public HomeImageHistory() {

  }

  public HomeImageHistory(int id, HomeHistoryLog homeHistoryLog, String imageUrl) {
    this.id = id;
    this.homeHistoryLog = homeHistoryLog;
    this.imageUrl = imageUrl;
  }

  public int getId() {
    return id;
  }

  public HomeHistoryLog getHomeHistoryLog() {
    return homeHistoryLog;
  }

  public void setHomeHistoryLog(HomeHistoryLog homeHistoryLog) {
    this.homeHistoryLog = homeHistoryLog;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
