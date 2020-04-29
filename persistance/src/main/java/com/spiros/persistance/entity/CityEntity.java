package com.spiros.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "city")
public class CityEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 100)
    private String name;

    @OneToOne(mappedBy = "city")
    private UserEntity user;


    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
