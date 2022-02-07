package com.fr.allianz.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel
public class AllianzEntityDto implements Serializable {
    @ApiModelProperty(value = "Id of entity", example = "1")
    private long id;
    @ApiModelProperty(value = "label of entity", example = "toto")
    private String label;
    @ApiModelProperty(value = "date of entity", example = "1991-12-12")
    private Date date;
}
