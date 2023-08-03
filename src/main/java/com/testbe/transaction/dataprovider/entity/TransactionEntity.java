package com.testbe.transaction.dataprovider.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    private String id;

    @SerializedName("this_account")
    private AccountEntity account;

    @SerializedName("other_account")
    private OtherAccountEntity otherAccount;

    private DetailEntity details;

}
