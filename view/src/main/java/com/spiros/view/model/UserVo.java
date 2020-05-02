package com.spiros.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The user", value = "User")
public class UserVo {

    @ApiModelProperty(value = "User's id", example = "379")
    private Long id;

    @ApiModelProperty(value = "User's username", example = "sample_username")
    private String username;

    @ApiModelProperty(value = "User's first name", example = "Tom")
    private String firstName;

    @ApiModelProperty(value = "User's last name", example = "White")
    private String lastName;

    private CityVo city;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

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

    public CityVo getCity() {
        return city;
    }

    public void setCity(final CityVo city) {
        this.city = city;
    }
}


