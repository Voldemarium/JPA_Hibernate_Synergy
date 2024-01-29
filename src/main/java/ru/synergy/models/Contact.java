package ru.synergy.models;

import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //, referencedColumnName = "id"
    private User user;

    @Column(name = "\"contactName\"", nullable = false)
    private String contactName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    String email;

    @Override
    public String toString() {
        return "Contact{" +
                "id= " + id +
                ", user_id=" + user.getId() +
                ", contactName='" + contactName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
