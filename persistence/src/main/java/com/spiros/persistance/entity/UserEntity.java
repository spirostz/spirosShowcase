package com.spiros.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 100)
    private String username;

    @Column(name = "first_name")
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 100)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(final CityEntity city) {
        this.city = city;
    }

}
