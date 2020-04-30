package com.spiros.persistance.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "city")
public class CityEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 100)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(final Set<UserEntity> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
