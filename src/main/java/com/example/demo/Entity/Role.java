package com.example.demo.Entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

  //  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
  //  private List roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
