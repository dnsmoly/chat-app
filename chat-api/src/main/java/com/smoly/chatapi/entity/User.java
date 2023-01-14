package com.smoly.chatapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<ChatMessage> messages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
