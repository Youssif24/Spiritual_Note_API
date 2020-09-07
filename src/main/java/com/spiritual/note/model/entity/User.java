package com.spiritual.note.model.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    @NotNull
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    @Nullable
    private String password;

    public User(String name,String password ,int age) {
        this.name = name;
        this.age = age;
        this.password=password;
    }
}
