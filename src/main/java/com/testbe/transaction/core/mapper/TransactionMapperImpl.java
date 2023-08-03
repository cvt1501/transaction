package com.testbe.transaction.core.mapper;

import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.dataprovider.entity.TransactionEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionMapperImpl {

    public TransactionDTO toDTO(TransactionEntity entity) {
        log.info("Starting to map transaction id {} entity to DTO", entity.getId());

        return TransactionDTO
                .builder()
                .id(entity.getId())
                .accountId(entity.getAccount().getId())
                .counterPartyAccount(entity.getOtherAccount().getNumber())
                .counterPartyName(entity.getOtherAccount().getHolder().getName())
                .counterPartyLogoPath(entity.getOtherAccount().getMetadata().getImageUrl())
                .instructedAmount(entity.getDetails().getValue().getAmount())
                .instructedCurrency(entity.getDetails().getValue().getCurrency())
                .transactionAmount(entity.getDetails().getValue().getAmount())
                .transactionCurrency(entity.getDetails().getValue().getCurrency())
                .transactionType(entity.getDetails().getType())
                .description(entity.getDetails().getDescription())
                .build();
    }

}
