package com.czh.springboot.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DDDDomainModel {

    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "uuid")
    private String uuid;
}
