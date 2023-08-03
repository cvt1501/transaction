package com.testbe.transaction.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtherAccountEntity {

    private String number;

    private HolderEntity holder;

    private MetadataEntity metadata;

}
