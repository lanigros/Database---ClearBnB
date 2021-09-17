package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Home> homes = new ArrayList<>();

    public Host() {
    }

    public Host(int id, User user, List<Home> homes) {
        this.id = id;
        this.user = user;
        this.homes = homes;
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Host" + "id=" + id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
