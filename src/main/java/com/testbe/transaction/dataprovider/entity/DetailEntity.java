package com.testbe.transaction.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEntity {

    private ValueEntity value;

    private String type;

    private String description;

}
