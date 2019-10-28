package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_role", schema = "backend", catalog = "")
public class UserRole {
    private int id;
    private String name;
    private Collection<UserDetails> userDetailsById;

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

        UserRole userRole = (UserRole) o;

        if (id != userRole.id) return false;
        if (name != null ? !name.equals(userRole.name) : userRole.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userRoleByUserRoleId")
    public Collection<UserDetails> getUserDetailsById() {
        return userDetailsById;
    }

    public void setUserDetailsById(Collection<UserDetails> userDetailsById) {
        this.userDetailsById = userDetailsById;
    }
}
