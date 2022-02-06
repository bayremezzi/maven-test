package com.fr.allianz.service.dto;

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
public class AllianzEntityDto implements Serializable {
    //@ApiModelProperty(value = "Id of entity", example = "123456")
    private long id;
    private String label;
    private Date date;
}
