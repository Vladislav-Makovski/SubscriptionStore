package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_details", schema = "backend", catalog = "")
public class UserDetails {
    private int id;
    private String username;
    private String password;
    private String email;
//    private int userRoleId;
//    private Collection<Customer> customersById;
//    private Collection<Organization> organizationsById;
    private UserRole userRoleByUserRoleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Basic
//    @Column(name = "user_role_id")
//    public int getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(int userRoleId) {
//        this.userRoleId = userRoleId;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserDetails that = (UserDetails) o;
//
//        if (id != that.id) return false;
//        if (userRoleId != that.userRoleId) return false;
//        if (username != null ? !username.equals(that.username) : that.username != null) return false;
//        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (email != null ? !email.equals(that.email) : that.email != null) return false;
//
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (id != that.id) return false;
        if (userRoleByUserRoleId.getId() != that.userRoleByUserRoleId.getId()) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + userRoleByUserRoleId.getId();
        return result;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + userRoleId;
//        return result;
//    }

//    @OneToMany(mappedBy = "userDetailsByUserDetailsId")
//    public Collection<Customer> getCustomersById() {
//        return customersById;
//    }
//
//    public void setCustomersById(Collection<Customer> customersById) {
//        this.customersById = customersById;
//    }
//
//    @OneToMany(mappedBy = "userDetailsByUserDetailsId")
//    public Collection<Organization> getOrganizationsById() {
//        return organizationsById;
//    }
//
//    public void setOrganizationsById(Collection<Organization> organizationsById) {
//        this.organizationsById = organizationsById;
//    }

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false)
    public UserRole getUserRoleByUserRoleId() {
        return userRoleByUserRoleId;
    }

    public void setUserRoleByUserRoleId(UserRole userRoleByUserRoleId) {
        this.userRoleByUserRoleId = userRoleByUserRoleId;
    }
}
