package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "status_sub", schema = "backend", catalog = "")
public class StatusSub {
    private int id;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusSub statusSub = (StatusSub) o;

        if (id != statusSub.id) return false;
        if (name != null ? !name.equals(statusSub.name) : statusSub.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
