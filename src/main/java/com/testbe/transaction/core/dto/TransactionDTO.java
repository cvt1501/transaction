package com.testbe.transaction.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionDTO {

    private String id;

    private String accountId;

    private String counterPartyAccount;

    private String counterPartyName;

    private String counterPartyLogoPath;

    private double instructedAmount;

    private String instructedCurrency;

    private double transactionAmount;

    private String transactionCurrency;

    private String transactionType;

    private String description;

}
