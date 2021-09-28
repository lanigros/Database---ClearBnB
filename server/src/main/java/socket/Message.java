package socket;

public class Message {

  private String id;
  private String uuid;
  private String msg;

  public Message() {
  }

  @Override
  public String toString() {
    return "Message{" + "id='" + id + '\'' + ", uuid=" + uuid + ", msg='" + msg + '\'' + '}';
  }

  public String getId() {
    return id;
  }

  public Message(String id, String uuid, String msg) {
    this.id = id;
    this.uuid = uuid;
    this.msg = msg;
  }

  public void setId(String id) {
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
