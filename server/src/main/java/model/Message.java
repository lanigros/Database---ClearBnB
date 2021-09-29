package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@NamedQueries({@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m ")})

public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String uuid;
  private String msg;

  public Message() {
  }

  public Message(String uuid, String msg) {

    this.uuid = uuid;
    this.msg = msg;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
