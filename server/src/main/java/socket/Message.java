package socket;

public class Message {

  private String id;
  private int uuid;
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

  public void setId(String id) {
    this.id = id;
  }

  public int getUuid() {
    return uuid;
  }

  public void setUuid(int uuid) {
    this.uuid = uuid;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
