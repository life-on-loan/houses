package ru.junior.test_task.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "owner_id", nullable = false)
    Integer ownerId;

    @Column(name = "users_id")
    @ElementCollection
    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<User> usersId = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public List<User> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<User> usersId) {
        this.usersId = usersId;
    }
}
