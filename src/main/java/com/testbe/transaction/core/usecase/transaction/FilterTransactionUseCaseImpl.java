package com.testbe.transaction.core.usecase.transaction;

import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.mapper.TransactionMapperImpl;
import com.testbe.transaction.dataprovider.entity.TransactionEntity;
import com.testbe.transaction.dataprovider.gateway.FileReaderGatewayImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class FilterTransactionUseCaseImpl {

    private final FileReaderGatewayImpl fileReaderGateway;

    private final TransactionMapperImpl transactionMapper;

    public List<TransactionDTO> filterTransaction(String type) {
        final List<TransactionEntity> transactionEntities = fileReaderGateway.readJsonFile();

        return transactionEntities
                .stream()
                .map(transactionMapper::toDTO)
                .filter(transaction -> transaction.getTransactionType().equals(type))
                .collect(Collectors.toList());
    }

}
