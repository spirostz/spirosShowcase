package com.spiros.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The city", value = "City")
public class CityVo {

    @ApiModelProperty(value = "City's id", example = "254")
    private Long id;

    @ApiModelProperty(value = "City's name in english", example = "Athens")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
