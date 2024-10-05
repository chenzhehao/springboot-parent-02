package com.czh.springboot.controller.entity.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DDDDomainResp {

    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "uuid")
    private String uuid;
}
